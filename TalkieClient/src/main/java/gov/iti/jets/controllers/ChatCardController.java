package gov.iti.jets.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import gov.iti.jets.manager.MainPanelManager;
import gov.iti.jets.models.Chat;
import gov.iti.jets.models.CurrentUser;
import gov.iti.jets.models.GroupChat;
import gov.iti.jets.models.Message;
import gov.iti.jets.models.RegularChat;
import gov.iti.jets.network.controllers.MessageController;
import gov.iti.jets.network.manager.NetworkManager;
import gov.iti.jets.controllers.ChattingPanelController;
import gov.iti.jets.dto.requests.GetMessagesRequest;
import gov.iti.jets.dto.responses.GetMessagesResponse;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

public class ChatCardController implements Initializable, FXMLController{
    @FXML
    private HBox chatHBox;

    @FXML
    private ImageView chatImageView;

    @FXML
    private Label chatNameLabel;

    @FXML
    private Label latestMessageLabel;

    @FXML
    private Label latestMessageTimeLabel;

    @FXML
    private Label numberOfUnreadMessages;

    @FXML
    private Circle chatStatusCircle;

    
    private boolean isRegular;
    private RegularChat regularchat;
    private GroupChat groupChat;

    private List<Message> messagesList;
    private final Map<String, MessageCardController> messageControllerList = new HashMap<>(); 
    private final Map<String, HBox> messagessLayouts = new HashMap<>(); 
    private Message latestMessage;
    Timestamp latestMessageTimeStamp = new Timestamp(0);
    

    // public ChatCardController(Chat chat){
    //     this.chat=chat;
    //     if (chat instanceof RegularChat)displayRegularChatInfo((RegularChat)chat);
    //     if (chat instanceof GroupChat)displayGroupChatInfo((GroupChat)chat);
    // }

    public ChatCardController(RegularChat regularchat){
        this.regularchat=regularchat;
        isRegular = true;  
    }

    public ChatCardController(GroupChat groupChat){
        this.groupChat=groupChat;
        isRegular = false; 
    }

    public List<Message> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(List<Message> messagesList) {
        this.messagesList = messagesList;
    }

    public Chat getChat() {
        if(isRegular)return regularchat;
        return groupChat;
    }

    // public void setChat(Chat chat) {
    //     this.chat = chat;
    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        if(isRegular)displayRegularChatInfo(regularchat);
        else displayGroupChatInfo(groupChat);

        chatHBox.setOnMouseClicked((MouseEvent event)->{
            ChattingPanelController chattingPanelController = (ChattingPanelController)MainPanelManager.INSTANCE.loadContent("chatting-panel");

            chattingPanelController.setChat(isRegular?regularchat:groupChat);
            chattingPanelController.setupChatInfo();
            chattingPanelController.loadMessages(messagessLayouts.values());

        });

        try {
            MessageController messageController = (MessageController) NetworkManager.getRegistry().lookup("MessageController");
            GetMessagesResponse response = messageController.getAllMessages(new GetMessagesRequest(isRegular?regularchat:groupChat));
            response.getMessageList().forEach((x)->addMessage(x));
            response.getMessageList().forEach(System.out::println);
            // System.out.println("TRIED to PULL MESSAGES!!!!!!!!!!!!");
            // GetMessagesResponse response3 = messageController.getAllMessages(new GetMessagesRequest(new Chat("83734688-1d3c-4943-8c86-21b1e72af8ae")));
            // response3.getMessageList().forEach(System.out::println);
        } catch (RemoteException e ) {
            e.printStackTrace();
        } catch (NotBoundException e){
            e.printStackTrace();
        }

        if(latestMessage!=null){
            latestMessageLabel.setText(latestMessage.getContent());
            SimpleDateFormat dateFormat;
            if(Timestamp.valueOf(LocalDateTime.now()).getTime() - latestMessage.getSentAt().getTime() < 86_400_000) dateFormat = new SimpleDateFormat("HH:mm");
            else  dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            latestMessageTimeLabel.setText(dateFormat.format(latestMessage.getSentAt()));
        }else latestMessageTimeLabel.setText("");
    }

    private void displayRegularChatInfo(RegularChat chat){

        chatNameLabel.setText(chat.getFirstParticipantId().getUserName());

        ByteArrayInputStream inStreambj = new ByteArrayInputStream(chat.getFirstParticipantId().getPicture());
        chatImageView.setImage(new Image(inStreambj)); 
        chatStatusCircle.setRadius(0); /////to be changed for status
    }

    private void displayGroupChatInfo(GroupChat chat){
        chatNameLabel.setText(chat.getName()); 
        chatStatusCircle.setRadius(0);
        chatImageView.setImage(new Image(getClass().getClassLoader().getResource("images/default_user.png").toString())); 
        //To BE Modified when adding Group chat Image;
    }
    
    private void addMessage(Message message){
        if(message.getSentAt().compareTo(latestMessageTimeStamp)>0){
            latestMessage = message;
            latestMessageTimeStamp = message.getSentAt();
        }
        try {
            MessageCardController messageCardController = new MessageCardController(message);
            FXMLLoader loader = new FXMLLoader();
            messageControllerList.put(message.getChatId()+message.getSentAt().toString(),messageCardController);
            loader.setController(messageCardController);
            HBox messageCard = loader.load(getClass().getClassLoader().getResource("views/components/message-card.fxml").openStream());
            messagessLayouts.put(message.getChatId()+message.getSentAt().toString(),messageCard);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
