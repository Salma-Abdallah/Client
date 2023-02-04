package gov.iti.jets.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import gov.iti.jets.manager.MainPanelManager;
import gov.iti.jets.manager.StageManager;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class sideBarController implements Initializable, FXMLController{

    @FXML
    private ImageView sideBar_logo_view;

    // @FXML
    // private StackPane sideBar_notification_stack;

    @FXML
    private ImageView sideBar_notification_view;

    @FXML
    private Circle sideBar_notification_on_circle;

    @FXML
    private ImageView sideBar_add_friend_view;

    @FXML
    private ImageView sideBar_blocked_list_view;

    @FXML
    private ImageView sideBar_status_icon_view;

    @FXML
    private HBox sideBar_space_HBox;

    @FXML
    private ImageView sideBar_user_profile_view;

    @FXML
    private ImageView sideBar_logout_view;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        sideBar_notification_view.setOnMouseClicked((MouseEvent event)->{
            MainPanelManager.INSTANCE.loadContent("friend-request");
        });

        sideBar_blocked_list_view.setOnMouseClicked((MouseEvent event)->{
            MainPanelManager.INSTANCE.loadContent("block-list");
        });

        sideBar_user_profile_view.setOnMouseClicked((MouseEvent event)->{
            MainPanelManager.INSTANCE.loadContent("user-profile");
        });

        sideBar_logout_view.setOnMouseClicked((MouseEvent event)->{
            StageManager.INSTANCE.loadScene("welcome");
        });
        
    }

}

