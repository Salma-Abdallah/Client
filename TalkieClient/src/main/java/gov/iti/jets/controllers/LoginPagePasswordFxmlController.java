package gov.iti.jets.controllers;

import java.net.URL;
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

    // @FXML
    // void initialize() {
        
    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        previousButton.setOnMouseClicked((MouseEvent event)->{
            StageManager.INSTANCE.loadScene("login-page-username");
        });

        submitButton.setOnAction((ActionEvent event)->{
            //set current user password after hashing from passwordTextField.getText()
            //validate password
            MainAlignmentController mainAlignmentController = (MainAlignmentController)StageManager.INSTANCE.loadScene("main-alignment");
            MainPanelManager.INSTANCE.setup(mainAlignmentController.getMainHBox());

        });
        
    }

}
