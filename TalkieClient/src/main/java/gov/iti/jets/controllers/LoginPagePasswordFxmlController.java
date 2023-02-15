package gov.iti.jets.controllers;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
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
import gov.iti.jets.network.controllers.impl.CallbackControllerSingleton;
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

    @FXML
    private Label loginFailedMessageLabel;
    static CashingUser cashingUser;


    // @FXML
    // void initialize() {

    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loginFailedMessageLabel.setText("");

        previousButton.setOnMouseClicked((MouseEvent event)->{
            StageManager.INSTANCE.loadScene("login-page-username");
        });
        CashingUser cashingUser1 = deserialize();
        if(cashingUser1 != null){
            passwordTextField.setText(cashingUser1.getPassWord());

        }else{
            serialize();
        }
        submitButton.setOnAction((ActionEvent event)->{


            loginPassword();


        });

        passwordTextField.setOnAction((ActionEvent event)->{
            loginPassword();
        });

    }
    private void loginPassword(){
        String password = EncryptionUtil.encrypt(passwordTextField.getText());

        LoginRequest loginRequest = new LoginRequest(CurrentUser.getInstance().getUser().getPhoneNumber(), password);
        try {

            AuthenticationController authenticationController = (AuthenticationController) NetworkManager.getRegistry().lookup("AuthenticationController");
            LoginResponse response = authenticationController.login(loginRequest);
            System.out.println(response);
            if (response != null){
                loginFailedMessageLabel.setText("");
                String hashPassWord = EncryptionUtil.encrypt(passwordTextField.getText());
                cashingUser= new CashingUser(response.getPhoneNumber(),hashPassWord);
                CurrentUser.getInstance().setUser(new User(response.getUserName(), response.getPhoneNumber(),
                        response.getEmail(), response.getPassword(), response.getGender(), response.getCountry(),
                        response.getBirthDate(), response.getOnlineStatus(), response.getBio(), response.getPicture(),
                        response.getPictureExtension()));
                ImageUtils.storeImage(CurrentUser.getInstance().getUser());
                MainAlignmentController mainAlignmentController = (MainAlignmentController)StageManager.INSTANCE.loadScene("main-alignment");
                MainPanelManager.INSTANCE.setup(mainAlignmentController.getMainHBox());
                CallbackControllerSingleton.getInstance().checkServerAvailability();
            }else{
                loginFailedMessageLabel.setText("PhoneNumber or Password Incorrect");
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
        serialize();
    }
    public static void serialize() {
        try (ObjectOutputStream objOStream1 = new ObjectOutputStream(new FileOutputStream("serialPassWord"))) {
            objOStream1.writeObject(cashingUser);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static CashingUser deserialize() {
        CashingUser object2 = null;
        boolean exists = Files.exists(Path.of("serialPassWord"));
        if (exists) {
            try (ObjectInputStream objIStrm = new ObjectInputStream(new
                    FileInputStream("serialPassWord"))) {
                object2 = (CashingUser) objIStrm.readObject();
                String decPassword = EncryptionUtil.decrypt(object2.getPassWord());
                CashingUser cashingUser = new CashingUser(object2.getPhoneNumber(), decPassword);
                return cashingUser;
            } catch (Exception e) {
                System.out.println("Exception during deserialization: " + e);
            }
        }
        return object2;
    }

}
