package gov.iti.jets.controllers;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import gov.iti.jets.dto.responses.LoginResponse;
import gov.iti.jets.manager.MainPanelManager;
import gov.iti.jets.manager.StageManager;
import gov.iti.jets.models.CurrentUser;
import gov.iti.jets.models.User;
import gov.iti.jets.network.controllers.AuthenticationController;
import gov.iti.jets.network.manager.NetworkManager;
import gov.iti.jets.utils.EncryptionUtil;
import gov.iti.jets.utils.ImageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import gov.iti.jets.dto.requests.LoginRequest;

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
            String password = EncryptionUtil.encrypt(passwordTextField.getText());

            LoginRequest loginRequest = new LoginRequest(CurrentUser.getInstance().getUser().getPhoneNumber(), password);
            try {

                AuthenticationController authenticationController = (AuthenticationController) NetworkManager.getRegistry().lookup("AuthenticationController");
                LoginResponse response = authenticationController.login(loginRequest);
                System.out.println(response);
                if (response != null){
                    CurrentUser.getInstance().setUser(new User(response.getUserName(), response.getPhoneNumber(),
                            response.getEmail(), response.getPassword(), response.getGender(), response.getCountry(),
                            response.getBirthDate(), response.getOnlineStatus(), response.getBio(), response.getPicture(),
                            response.getPictureExtension()));
                    ImageUtils.storeImage(CurrentUser.getInstance().getUser());
                    MainAlignmentController mainAlignmentController = (MainAlignmentController)StageManager.INSTANCE.loadScene("main-alignment");
                    MainPanelManager.INSTANCE.setup(mainAlignmentController.getMainHBox());
                }
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            } catch (NotBoundException e) {
                throw new RuntimeException(e);
            }

        });
        
    }

}
