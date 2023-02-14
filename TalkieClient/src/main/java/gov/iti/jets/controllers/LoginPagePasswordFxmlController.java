package gov.iti.jets.controllers;

import java.io.*;
import java.net.URL;
import java.security.KeyStore;
import java.util.Properties;
import java.util.ResourceBundle;

import gov.iti.jets.manager.MainPanelManager;
import gov.iti.jets.manager.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginPagePasswordFxmlController implements Initializable, FXMLController{

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


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        previousButton.setOnMouseClicked((MouseEvent event)->{
            StageManager.INSTANCE.loadScene("login-page-username");
        });
        submitButton.setOnAction((ActionEvent event)->{
            //set current user password after hashing from passwordTextField.getText()
            //validate password
            Properties prop = new Properties();
//            OutputStream output = null;
            try {
//                output = new FileOutputStream("autoLogin.properties");
                prop.setProperty("PassWord",passwordTextField.getText());
                prop.store(LoginPageUsernameFxmlController.output, null);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if(LoginPageUsernameFxmlController.output != null);
                try {
                    LoginPageUsernameFxmlController.output.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


            MainAlignmentController mainAlignmentController = (MainAlignmentController)StageManager.INSTANCE.loadScene("main-alignment");
            MainPanelManager.INSTANCE.setup(mainAlignmentController.getMainHBox());
            FileWriter file = null;


        });

    }

}
