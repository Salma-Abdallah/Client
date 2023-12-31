package gov.iti.jets.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import gov.iti.jets.manager.StageManager;
import gov.iti.jets.models.CurrentUser;
import javafx.event.ActionEvent;
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
    static OutputStream output = null;
    @FXML
    private Label previousLabel;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        CashingUser cashingUser1 = LoginPagePasswordFxmlController.deserialize();
        if(cashingUser1 != null) {
            phoneNoTextField.setText(cashingUser1.getPhoneNumber());
        }
        previousLabel.setOnMouseClicked((MouseEvent event)->{
            StageManager.INSTANCE.loadScene("welcome");
        });

        nextLabel.setOnMouseClicked((MouseEvent event)-> {
            loginUserName();
        });

        phoneNoTextField.setOnAction((ActionEvent event)->{
            loginUserName();
        });
    }
    public TextField getPhoneNoTextField() {
        return phoneNoTextField;
    }
    private void loginUserName(){
        StageManager.INSTANCE.loadScene("login-page-password");
        CurrentUser.getInstance().getUser().setPhoneNumber(phoneNoTextField.getText());
    }
}
