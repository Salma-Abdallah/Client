/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import gov.iti.jets.manager.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Sara Adel
 */
public class WelcomeController implements Initializable, FXMLController {

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // System.out.println("intial");
        loginButton.setOnAction((ActionEvent event)->{
            StageManager.INSTANCE.loadScene("login-page-username");
        });

        signUpButton.setOnAction((ActionEvent event)->{
            StageManager.INSTANCE.loadScene("signup-page");
        });
    } 

  
    
}
