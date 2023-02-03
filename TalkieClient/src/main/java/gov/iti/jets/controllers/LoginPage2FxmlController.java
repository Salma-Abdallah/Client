package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginPage2FxmlController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Label previousButton;

    @FXML
    private Button submitButton;

    @FXML
    void initialize() {
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'loginPage2FXML.fxml'.";
        assert previousButton != null : "fx:id=\"previousButton\" was not injected: check your FXML file 'loginPage2FXML.fxml'.";
        assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'loginPage2FXML.fxml'.";

    }

}
