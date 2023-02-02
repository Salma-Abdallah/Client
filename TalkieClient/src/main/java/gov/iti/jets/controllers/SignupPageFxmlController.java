package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SignupPageFxmlController {

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

    @FXML
    void initialize() {
        assert ConfirmPasswordTextField != null : "fx:id=\"ConfirmPasswordTextField\" was not injected: check your FXML file 'SignupPage1FXML.fxml'.";
        assert FemaleRadioButton != null : "fx:id=\"FemaleRadioButton\" was not injected: check your FXML file 'SignupPage1FXML.fxml'.";
        assert countryTextField != null : "fx:id=\"countryTextField\" was not injected: check your FXML file 'SignupPage1FXML.fxml'.";
        assert datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file 'SignupPage1FXML.fxml'.";
        assert emailTextField != null : "fx:id=\"emailTextField\" was not injected: check your FXML file 'SignupPage1FXML.fxml'.";
        assert maleRadioButton != null : "fx:id=\"maleRadioButton\" was not injected: check your FXML file 'SignupPage1FXML.fxml'.";
        assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file 'SignupPage1FXML.fxml'.";
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'SignupPage1FXML.fxml'.";
        assert phoneNoTextField != null : "fx:id=\"phoneNoTextField\" was not injected: check your FXML file 'SignupPage1FXML.fxml'.";
        assert previousLabel != null : "fx:id=\"previousLabel\" was not injected: check your FXML file 'SignupPage1FXML.fxml'.";
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'SignupPage1FXML.fxml'.";

    }

}
