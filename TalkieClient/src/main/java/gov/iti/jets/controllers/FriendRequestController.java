/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * FXML Controller class
 *
 * @author Sara Adel
 */
public class FriendRequestController implements Initializable, FXMLController {
    @FXML
    private HBox hgrow;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HBox.setHgrow(hgrow, Priority.ALWAYS);

    }
    
}
