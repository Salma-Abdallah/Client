package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MessageController implements Initializable, FXMLController {  
    @FXML
    private Label OfflineContacts;

    @FXML
    private ImageView creating_group;

    @FXML
    private Label onlineContact;

    @FXML
    private TextField search_chat;

    @FXML
    private ImageView view_Chat_Type;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //load messagesList()
    }
       
    
}
