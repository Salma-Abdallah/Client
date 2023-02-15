package gov.iti.jets.controllers;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;


import gov.iti.jets.models.CurrentUser;
import gov.iti.jets.models.Message;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class MessageCardController implements Initializable, FXMLController{
    @FXML
    private HBox completeMessageHBox;

    @FXML
    private ImageView senderImage;

    @FXML
    private VBox messageVBox;

    @FXML
    private HBox senderInfoHBox;

    @FXML
    private Label senderNameLabel;

    @FXML
    private Label senderPhoneLabel;

    @FXML
    private HBox messageAttachmentHBox;

    @FXML
    private ImageView fileIconImageView;

    @FXML
    private Label fileNameLabel;

    @FXML
    private Label fileSizeLabel;

    @FXML
    private TextFlow messageContentTextFlow;

    @FXML
    private Text messageText;

    @FXML
    private Label messageTimeLabel;

    @FXML
    private ImageView messageStatusImageView;

    private Message message;

    public MessageCardController(Message message){
        this.message = message;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        if(message.getAuthor().getPhoneNumber().equals(CurrentUser.getInstance().getUser().getPhoneNumber()))dispalyOwnMessage();
        else displayOtherMessage();
    }

    private void dispalyOwnMessage(){
        loadMessageData();

        completeMessageHBox.nodeOrientationProperty().set(NodeOrientation.RIGHT_TO_LEFT);
        messageVBox.setStyle("-fx-background-color: #d6d6d6; -fx-background-radius: 15 0 15 15");

        messageVBox.getChildren().remove(senderInfoHBox);
    }

    private void displayOtherMessage(){
        loadMessageData();

        ByteArrayInputStream inStreambj = new ByteArrayInputStream(message.getAuthor().getPicture());
        senderImage.setImage(new Image(inStreambj));

        senderNameLabel.setText(message.getAuthor().getUserName());
        senderPhoneLabel.setText(message.getAuthor().getPhoneNumber());
    }

    private void loadMessageData(){
        SimpleDateFormat dateFormat;
        if(Timestamp.valueOf(LocalDateTime.now()).getTime() - message.getSentAt().getTime() < 86_400_000) dateFormat = new SimpleDateFormat("HH:mm");
        else  dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        messageTimeLabel.setText(dateFormat.format(message.getSentAt()));

        messageText.setText(message.getContent());

        messageText.setFont(Font.font(message.getFontStyle()
        ,message.isBold()?FontWeight.BOLD:FontWeight.NORMAL
        ,message.isItalic()?FontPosture.ITALIC:FontPosture.REGULAR
        ,message.getFontSize()));

        messageText.setFill(Paint.valueOf(message.getFontColor()));

        messageVBox.getChildren().remove(messageAttachmentHBox);
    }
}
