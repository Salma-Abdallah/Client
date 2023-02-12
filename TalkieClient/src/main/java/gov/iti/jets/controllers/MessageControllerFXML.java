package gov.iti.jets.controllers;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.gluonhq.charm.glisten.control.ExpansionPanel;

import gov.iti.jets.dto.requests.GetChatsRequest;
import gov.iti.jets.dto.requests.GetMessagesRequest;
import gov.iti.jets.dto.responses.GetChatsResponse;
import gov.iti.jets.dto.responses.GetMessagesResponse;
import gov.iti.jets.models.Chat;
import gov.iti.jets.models.CurrentUser;
import gov.iti.jets.models.GroupChat;
import gov.iti.jets.models.RegularChat;
import gov.iti.jets.network.controllers.ChatController;
import gov.iti.jets.network.controllers.MessageController;
import gov.iti.jets.network.manager.NetworkManager;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MessageControllerFXML implements Initializable, FXMLController {  
    // @FXML
    // private Label OfflineContacts;

    @FXML
    private ImageView creating_group;

    // @FXML
    // private Label onlineContact;

    @FXML
    private TextField search_chat;

    @FXML
    private ExpansionPanel regularExpansionPanel;

    @FXML
    private ImageView view_Chat_Type;

    @FXML
    private VBox regularChatsVBox;

    @FXML
    private ExpansionPanel GroupExpansionPanel;

    @FXML
    private VBox groupChatsVBox;

    // private List<Chat> chatsList;

    // private List<ChatCardController> chatsControllerList;
    private final Map<String, ChatCardController> chatsControllerList = new HashMap<>(); 
    private final Map<String, HBox> contentsLayouts = new HashMap<>(); 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //load messagesList()
        retriveChatsfromDB();
        displayChats();
        regularExpansionPanel.setExpanded(true);
        GroupExpansionPanel.setExpanded(true);

    }

    private void displayChats(){

    }

    private void retriveChatsfromDB(){
        ChatController chatController;
        try {
            chatController = (ChatController) NetworkManager.getRegistry().lookup("ChatController");
            GetChatsResponse response = chatController.getAllChat(new GetChatsRequest(CurrentUser.getInstance().getUser().getPhoneNumber()));
            response.getAllRegularChatsList().forEach((x)-> addRegularChat(x));
            response.getAllGroupChatsList().forEach((x)-> addGroupChat(x));

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void addRegularChat(RegularChat chat){
        ChatCardController chatCardController = new ChatCardController(chat);
        HBox chatCard = createChatCard(chatCardController);
        if(chatCard!=null)regularChatsVBox.getChildren().add(chatCard); 
    }
    private void addGroupChat(GroupChat chat){
        ChatCardController chatCardController = new ChatCardController(chat);
        HBox chatCard = createChatCard(chatCardController);
        if(chatCard!=null)groupChatsVBox.getChildren().add(chatCard);

    }
    private HBox createChatCard(ChatCardController chatCardController){
        try {
            FXMLLoader loader = new FXMLLoader();
            chatsControllerList.put(chatCardController.getChat().getChatId(),chatCardController);
            loader.setController(chatCardController);
            HBox chatCard = loader.load(getClass().getClassLoader().getResource("views/components/chat-card.fxml").openStream());
            contentsLayouts.put(chatCardController.getChat().getChatId(),chatCard);
            return chatCard;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
       
}
