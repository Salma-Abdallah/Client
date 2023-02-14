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
    private Integer unseenMessagesCount;

    // private List<Message> messagesList;
    private final Map<String, MessageCardController> messageControllerList = new HashMap<>(); 
    private final Map<String, HBox> messagessLayouts = new HashMap<>(); 
    private Message latestMessage = null;
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

    // public List<Message> getMessagesList() {
    //     return messagesList;
    // }

    // public void setMessagesList(List<Message> messagesList) {
    //     this.messagesList = messagesList;
    // }

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
        latestMessageTimeLabel.setText("");
        latestMessageLabel.setText("");
        numberOfUnreadMessages.setVisible(false);

        if(isRegular)displayRegularChatInfo(regularchat);
        else displayGroupChatInfo(groupChat);

        chatHBox.setOnMouseClicked((MouseEvent event)->{
            ChattingPanelController chattingPanelController = (ChattingPanelController)MainPanelManager.INSTANCE.loadContent("chatting-panel");

            chattingPanelController.setChat(isRegular?regularchat:groupChat);
            chattingPanelController.setupChatInfo();
            chattingPanelController.loadMessages(messagessLayouts.values());

        });

        loadOldMessages();
        
    }

    private void loadOldMessages(){
        unseenMessagesCount = 0;
        try {
            MessageController messageController = (MessageController) NetworkManager.getRegistry().lookup("MessageController");
            GetMessagesResponse response = messageController.getAllMessages(new GetMessagesRequest(isRegular?regularchat:groupChat));
            response.getMessageList().forEach((x)->addMessage(x));
            // response.getMessageList().forEach(System.out::println);
        } catch (RemoteException e ) {
            e.printStackTrace();
        } catch (NotBoundException e){
            e.printStackTrace();
        }
    }

    private void displayRegularChatInfo(RegularChat chat){

        chatNameLabel.setText(chat.getFirstParticipantId().getUserName());

        ByteArrayInputStream inStreambj = new ByteArrayInputStream(chat.getFirstParticipantId().getPicture());
        chatImageView.setImage(new Image(inStreambj)); 

        // chatStatusCircle.setRadius(0); /////to be changed for status
    }

    private void displayGroupChatInfo(GroupChat chat){
        chatNameLabel.setText(chat.getName()); 
        chatStatusCircle.setRadius(0);
        chatImageView.setImage(new Image(getClass().getClassLoader().getResource("images/default_user.png").toString())); 
        //TODO Modify when adding Group chat Image;
    }
    
    public void addMessage(Message message){
        if(message.getSentAt().compareTo(latestMessageTimeStamp)>0){
            latestMessage = message;
            latestMessageTimeStamp = message.getSentAt();
        }
        if(!message.isSeen())unseenMessagesCount+=1;
        try {
            MessageCardController messageCardController = new MessageCardController(message);
            FXMLLoader loader = new FXMLLoader();
            messageControllerList.put(message.getChatId()+message.getSentAt().toString(),messageCardController);
            loader.setController(messageCardController);
            HBox messageCard = loader.load(getClass().getClassLoader().getResource("views/components/message-card.fxml").openStream());
            messagessLayouts.put(message.getChatId()+message.getSentAt().toString(),messageCard);
            updateChatCardInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateChatCardInfo(){
        if(!isRegular)System.out.println(groupChat.getName()+latestMessage.getSentAt());
        latestMessageLabel.setText(latestMessage.getContent());
        SimpleDateFormat dateFormat;
        if(Timestamp.valueOf(LocalDateTime.now()).getTime() - latestMessage.getSentAt().getTime() < 86_400_000) dateFormat = new SimpleDateFormat("HH:mm");
        else  dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        latestMessageTimeLabel.setText(dateFormat.format(latestMessage.getSentAt()));
        if(unseenMessagesCount>0){
            numberOfUnreadMessages.setText(Integer.toString(unseenMessagesCount));
            numberOfUnreadMessages.setVisible(true);
        }else{
            numberOfUnreadMessages.setVisible(false);
        }
    }
    
}
