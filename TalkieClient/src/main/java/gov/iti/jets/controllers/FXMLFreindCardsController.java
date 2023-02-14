/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import gov.iti.jets.manager.StageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


public class FXMLFreindCardsController implements Initializable, FXMLController {

    @FXML
    private Button acceptreq;

    @FXML
    private Button rejectReq;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rejectReq.setOnMouseClicked((MouseEvent event)->{
            StageManager.INSTANCE.loadScene("Friend-cards");
        });
       acceptreq.setOnMouseClicked((MouseEvent event)->{
            StageManager.INSTANCE.loadScene("Friend-cards");
        });
    }
    
}
