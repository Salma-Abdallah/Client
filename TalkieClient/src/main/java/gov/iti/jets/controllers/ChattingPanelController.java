package gov.iti.jets.controllers;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import gov.iti.jets.models.Chat;
import gov.iti.jets.models.RegularChat;
import gov.iti.jets.models.User;
import gov.iti.jets.models.RegularChat;
import gov.iti.jets.models.GroupChat;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ChattingPanelController implements Initializable, FXMLController{
    @FXML
    private VBox chattingPanelVBox;

    @FXML
    private HBox topPartHBox;

    @FXML
    private ImageView chatImageView;

    @FXML
    private VBox chatInfoImageView;

    @FXML
    private Label chatNameLabel;

    @FXML
    private Label chatNumbersLabel;

    @FXML
    private Button videoCallButton;

    @FXML
    private ImageView videoCallButtonImageView;

    @FXML
    private Button voiceCallButton;

    @FXML
    private ImageView voiceCallButtonImageView;

    @FXML
    private Button moreButton;

    @FXML
    private ImageView moreButtonImageView;

    @FXML
    private VBox messagesContainerVBox;

    @FXML
    private ChoiceBox<?> textFontButton;

    @FXML
    private ChoiceBox<?> textSizeChoiceBox;

    @FXML
    private Button textBoldButton;

    @FXML
    private ImageView textBoldButtonImageView;

    @FXML
    private Button textItalicButton;

    @FXML
    private ImageView textItalicButtonImageView;

    @FXML
    private Button textUnderlineButton;

    @FXML
    private ImageView textUnderlineButtonImageView;

    @FXML
    private Button textColorButton;

    @FXML
    private ImageView textColorButtonImageView;

    @FXML
    private Button textbackgroundColorButton;

    @FXML
    private ImageView textbackgroundColorButtonImageView;

    @FXML
    private Button emojiButton;

    @FXML
    private ImageView emojiButtonImageView;

    @FXML
    private Button attachmentButton;

    @FXML
    private ImageView attachmentButtonImageView;

    @FXML
    private TextField typingTextField;

    @FXML
    private Button voiceNoteButton;

    @FXML
    private ImageView voiceNoteButtonImageView;

    @FXML
    private Button sendButton;

    @FXML
    private ImageView sendButtonImageView;

    private Chat chat;
    private List<HBox> messagesHBoxList; 
    
    public Chat getChat() {
        return chat;
    }


    public void setChat(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
               
    }

    public void setupChatInfo (){
        if(chat instanceof RegularChat){
            setupRegularChatInfo((RegularChat)chat);
        }else if(chat instanceof GroupChat){
            setupGroupChatInfo((GroupChat)chat);
            //To BE Modified when adding Group chat Image;
        }
    }

    private void setupRegularChatInfo(RegularChat chat){

        chatNameLabel.setText(chat.getFirstParticipantId().getUserName()); 

        ByteArrayInputStream inStreambj = new ByteArrayInputStream(chat.getFirstParticipantId().getPicture());
        chatImageView.setImage(new Image(inStreambj)); 

        chatNumbersLabel.setText(chat.getFirstParticipantId().getPhoneNumber());

    }

    private void setupGroupChatInfo(GroupChat chat){
        chatNameLabel.setText(chat.getName());

        String chatParticipants= new String();
        int i=0;
        for(User user:chat.getParticipants()){
            if(i>0)chatParticipants+=", ";
            i++;
            chatParticipants+=user.getPhoneNumber();

        }
        chatNumbersLabel.setText(chatParticipants);
        chatImageView.setImage(new Image(getClass().getClassLoader().getResource("images/default_user.png").toString())); 
        //To BE Modified when adding Group chat Image;
    }

    public void loadMessages(Collection<HBox> messagesHBoxList){
        this.messagesHBoxList=new ArrayList<>(messagesHBoxList);
        messagesContainerVBox.getChildren().clear();
        messagesContainerVBox.getChildren().addAll(messagesHBoxList);

        // for(HBox messageHBox:messagesHBoxList){
        //     messagesContainerVBox.getChildren().add(messageHBox);
        // }
    }

}
