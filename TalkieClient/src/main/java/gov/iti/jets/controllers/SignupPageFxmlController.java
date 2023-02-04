package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import gov.iti.jets.manager.MainPanelManager;
import gov.iti.jets.manager.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignupPageFxmlController implements Initializable, FXMLController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ConfirmPasswordTextField;

    @FXML
    private RadioButton FemaleRadioButton;

    @FXML
    private TextField countryTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField emailTextField;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField phoneNoTextField;

    @FXML
    private Label previousLabel;

    @FXML
    private Button startButton;

    // @FXML
    // void initialize() {
        

    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        previousLabel.setOnMouseClicked((MouseEvent event)->{
            StageManager.INSTANCE.loadScene("welcome");
        });

        startButton.setOnAction((ActionEvent event)->{
            //RegisterUser
            MainAlignmentController mainAlignmentController = (MainAlignmentController)StageManager.INSTANCE.loadScene("main-alignment");
            MainPanelManager.INSTANCE.setup(mainAlignmentController.getMainHBox());
        });
        
    }

}
