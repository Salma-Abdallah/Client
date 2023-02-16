package gov.iti.jets.controllers;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.gluonhq.charm.glisten.control.ExpansionPanel;

import gov.iti.jets.dto.requests.CreateGroupChatRequest;
import gov.iti.jets.dto.requests.GetChatsRequest;
import gov.iti.jets.dto.requests.GetMessagesRequest;
import gov.iti.jets.dto.responses.CreateGroupChatResponse;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MessageControllerFXML implements Initializable, FXMLController { 
    @FXML
    private VBox mainVBox;
    // @FXML
    // private Label OfflineContacts;

    @FXML
    private ImageView creating_group;

    // @FXML
    // private Label onlineContact;

    @FXML
    private TextField addGroupChat;

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

    private Boolean  addGroupFieldVisible = false;
    // private List<Chat> chatsList;

    // private List<ChatCardController> chatsControllerList;
    private final ObservableMap<String, ChatCardController> chatCardsControllerList = FXCollections.observableHashMap(); 
    private final ObservableMap<String, HBox> regularChatLayouts = FXCollections.observableHashMap(); 
    private final ObservableMap<String, HBox> groupChatLayouts = FXCollections.observableHashMap(); 

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        regularChatsVBox.getChildren().addAll(regularChatLayouts.values());
        groupChatsVBox.getChildren().addAll(groupChatLayouts.values());

        regularExpansionPanel.setExpanded(true);
        GroupExpansionPanel.setExpanded(true);

        retriveChatsfromDB();
        // displayChats();

        mainVBox.getChildren().remove(addGroupChat);
        
        creating_group.setOnMouseClicked((MouseEvent event)->{
            if(!addGroupFieldVisible){
                addGroupFieldVisible=true;
                mainVBox.getChildren().add(1,addGroupChat);
                addGroupChat.setEditable(true);
                creating_group.setImage(new Image(getClass().getClassLoader().getResource("images/expanded.png").toString()));
            }else{
                addGroupFieldVisible=false;
                mainVBox.getChildren().remove(addGroupChat);
                creating_group.setImage(new Image(getClass().getClassLoader().getResource("images/group_add.png").toString()));
            }
        });

        addGroupChat.setOnAction((ActionEvent event)->{
            if(!addGroupChat.getText().trim().equals("")){
                try {
                    ChatController chatController = (ChatController) NetworkManager.getRegistry().lookup("ChatController");
                    CreateGroupChatResponse response = chatController.createGroupChat(new CreateGroupChatRequest(CurrentUser.getInstance().getUser().getPhoneNumber(), addGroupChat.getText()));
                    if(response.getNewGroupChat()!=null)addGroupChat((GroupChat)response.getNewGroupChat());
                } catch (RemoteException | NotBoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }

    // private void displayChats(){

    // }

    private void retriveChatsfromDB(){
        try {
            ChatController chatController = (ChatController) NetworkManager.getRegistry().lookup("ChatController");
            GetChatsResponse response = chatController.getAllChat(new GetChatsRequest(CurrentUser.getInstance().getUser().getPhoneNumber()));
            
            response.getAllRegularChatsList().forEach((x)-> addRegularChat(x));
            response.getAllGroupChatsList().forEach((x)-> addGroupChat(x));
            
            
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addRegularChat(RegularChat chat){
        ChatCardController chatCardController = new ChatCardController(chat);
        HBox chatCard = createChatCard(chatCardController);
        regularChatLayouts.put(chatCardController.getChat().getChatId(),chatCard);
        // refreshRegularChatVbox();
        if(chatCard!=null)regularChatsVBox.getChildren().add(1,chatCard); 
    }
    public void addGroupChat(GroupChat chat){
        ChatCardController chatCardController = new ChatCardController(chat);
        HBox chatCard = createChatCard(chatCardController);
        groupChatLayouts.put(chatCardController.getChat().getChatId(),chatCard);
        // refreshGroupChatVbox();
        if(chatCard!=null)groupChatsVBox.getChildren().add(1,chatCard);

    }
    private HBox createChatCard(ChatCardController chatCardController){
        try {
            FXMLLoader loader = new FXMLLoader();
            chatCardsControllerList.put(chatCardController.getChat().getChatId(),chatCardController);
            loader.setController(chatCardController);
            HBox chatCard = loader.load(getClass().getClassLoader().getResource("views/components/chat-card.fxml").openStream());
            return chatCard;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    // private void updateChatCard(String chatId){
    //     if(regularChatLayouts.get(chatId)!=null){
    //         chatCardsControllerList.get(chatId).updateChatCardInfo();
    //     }
    //     if(groupChatLayouts.get(chatId)!=null){
    //         chatCardsControllerList.get(chatId).updateChatCardInfo();
    //     }
    // }

    public void riseChatCard(String chatId){
        if(regularChatLayouts.get(chatId)!=null){
            regularChatsVBox.getChildren().remove(regularChatLayouts.get(chatId));
            regularChatsVBox.getChildren().add(1,regularChatLayouts.get(chatId));
        }
        if(groupChatLayouts.get(chatId)!=null){
            groupChatsVBox.getChildren().remove(groupChatLayouts.get(chatId));
            groupChatsVBox.getChildren().add(1,groupChatLayouts.get(chatId));
        }
    }

    public ChatCardController getChatCardController(String ChatId){
        return chatCardsControllerList.get(ChatId);
    }
    public void updateChatStatus(String chatId, String status){
        chatCardsControllerList.get(chatId).updateChatCardStatus(status);
    }

    public String getChatNameByChatId(String chatId){
        return chatCardsControllerList.get(chatId).getChatName();
    }
    public void clearAll(){
        chatCardsControllerList.clear();
        regularChatLayouts.clear();
        groupChatLayouts.clear();
    }

    // private void refreshRegularChatVbox(){
    //     regularChatsVBox.getChildren().removeAll(groupChatLayouts.values());
    //     regularChatsVBox.getChildren().addAll(groupChatLayouts.values());
    // }
    // private void refreshGroupChatVbox(){
    //     groupChatsVBox.getChildren().removeAll(groupChatLayouts.values());
    //     groupChatsVBox.getChildren().addAll(groupChatLayouts.values());
    // }  
}
