package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class NotificationController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane notification;

    @FXML
    private Text talkie;

    @FXML
    private Text name;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.print("arg0");
    }
}
