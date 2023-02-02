package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginPage1FxmlController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label nextLabel;

    @FXML
    private TextField phoneNoTextField;

    @FXML
    private Label previousLabel;

    @FXML
    void initialize() {
        assert nextLabel != null : "fx:id=\"nextLabel\" was not injected: check your FXML file 'loginPage1FXML.fxml'.";
        assert phoneNoTextField != null : "fx:id=\"phoneNoTextField\" was not injected: check your FXML file 'loginPage1FXML.fxml'.";
        assert previousLabel != null : "fx:id=\"previousLabel\" was not injected: check your FXML file 'loginPage1FXML.fxml'.";

    }

}
