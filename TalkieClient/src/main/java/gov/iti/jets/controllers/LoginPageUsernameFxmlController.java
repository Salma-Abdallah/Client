package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import gov.iti.jets.manager.StageManager;
import gov.iti.jets.models.CurrentUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginPageUsernameFxmlController implements Initializable, FXMLController{

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

    // @FXML
    // void initialize() {
        
    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        previousLabel.setOnMouseClicked((MouseEvent event)->{
            StageManager.INSTANCE.loadScene("welcome");
        });

        nextLabel.setOnMouseClicked((MouseEvent event)->{
            //set current user uswername from phoneNoTextField.getText()
            //validate username exists
            StageManager.INSTANCE.loadScene("login-page-password");
            CurrentUser.getInstance().getUser().setPhoneNumber(phoneNoTextField.getText());
        });
        
    }

}
