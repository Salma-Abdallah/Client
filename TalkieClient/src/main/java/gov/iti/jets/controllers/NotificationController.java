package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class NotificationController implements Initializable, FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane notification;

    @FXML
    private Text talkie;

    @FXML
    private Text nameText;

    @FXML
    private Text messageText;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }
    public void setData(String nameText,String Message){
        this.nameText.setText(nameText);
        this.messageText.setText(Message);
    }
}
