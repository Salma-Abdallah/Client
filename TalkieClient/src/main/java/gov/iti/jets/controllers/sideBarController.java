package gov.iti.jets.controllers;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import gov.iti.jets.manager.MainPanelManager;
import gov.iti.jets.manager.StageManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.util.Callback;

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
    private HBox sideBar_space_HBox;

    @FXML
    private ImageView sideBar_user_profile_view;

    @FXML
    private ImageView sideBar_logout_view;

    @FXML
    private ComboBox<ImageView> statusChoiceBox;

    private ImageView onlineStatus;
    private ImageView busyStatus;
    private ImageView awayStatus;
    private ImageView appearOfflineStatus;

    LoginPagePasswordFxmlController loginPagePasswordFxmlController = new LoginPagePasswordFxmlController();




    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        statusComboBoxImageFactory();
        statusChoiceBox.setValue(onlineStatus);

        statusChoiceBox.setOnAction((ActionEvent event)->{
            System.out.println(statusChoiceBox.getValue());
            if(statusChoiceBox.getValue() == onlineStatus){System.out.println("ONLINE!!!!!!!!!!!!!!!!!!!!");}
            if(statusChoiceBox.getValue() == appearOfflineStatus){System.out.println("OFFFFFFFLINE!!!!!!!!!!!!!!!!!!!!");}
        });

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
//            File file = new File("serial");
//            OutputStream out = null;
//            try {
//                out = new FileOutputStream(file, false);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//
//            if (!file.delete()) {
//                try {
//                    throw new IOException("Unable to delete file: " + file.getAbsolutePath());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }

        });


        
    }

    public void statusComboBoxImageFactory(){
        onlineStatus = new ImageView(new Image(getClass().getClassLoader().getResource("images/connection-status-online.png").toString()));
        busyStatus= new ImageView(new Image(getClass().getClassLoader().getResource("images/connection-status-busy.png").toString()));
        awayStatus = new ImageView(new Image(getClass().getClassLoader().getResource("images/connection-status-away.png").toString()));
        appearOfflineStatus = new ImageView(new Image(getClass().getClassLoader().getResource("images/connection-status-offline.png").toString()));

        statusChoiceBox.setItems(FXCollections.observableArrayList(onlineStatus,busyStatus,awayStatus,appearOfflineStatus));

        statusChoiceBox.setCellFactory(new Callback<ListView<ImageView>, ListCell<ImageView>>() {
            @Override
            public ListCell<ImageView> call(ListView<ImageView> p) {
                return new ListCell<ImageView>() {
                    @Override
                    protected void updateItem(ImageView item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            Image icon=null;
                            try {
                                switch (this.getIndex()){
                                    case 0:
                                        icon = new Image(getClass().getClassLoader().getResource("images/connection-status-online.png").toString());
                                        break;
                                    case 1:
                                        icon = new Image(getClass().getClassLoader().getResource("images/connection-status-busy.png").toString());
                                        break;
                                    case 2:
                                        icon = new Image(getClass().getClassLoader().getResource("images/connection-status-away.png").toString());
                                        break;
                                    case 3:
                                        icon = new Image(getClass().getClassLoader().getResource("images/connection-status-offline.png").toString());
                                        break;
                                }
                                ImageView iconImageView = new ImageView(icon);
                                iconImageView.setFitHeight(30);
                                iconImageView.setPreserveRatio(true);
                                setGraphic(iconImageView);
                            } catch(NullPointerException ex) {
                                ex.printStackTrace();
                                // icon = new Image(getClass().getClassLoader().getResourceAsStream(iconPath));
                            }
                            
                        }
                    }
                };
            }

        });
    }

}

