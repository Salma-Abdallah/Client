package gov.iti.jets;

import gov.iti.jets.dto.requests.GetMessagesRequest;
import gov.iti.jets.dto.requests.LoginRequest;
import gov.iti.jets.dto.requests.RegisterRequest;
import gov.iti.jets.dto.responses.GetMessagesResponse;
import gov.iti.jets.dto.responses.LoginResponse;
import gov.iti.jets.dto.responses.RegisterResponse;
import gov.iti.jets.manager.StageManager;
import gov.iti.jets.models.Chat;
import gov.iti.jets.network.controllers.AuthenticationController;
import gov.iti.jets.network.controllers.MessageController;
import gov.iti.jets.network.controllers.UserController;
import gov.iti.jets.network.manager.NetworkManager;
import gov.iti.jets.utils.EncryptionUtil;
import gov.iti.jets.utils.ImageUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Locale;

public class TalkieClientApplication extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        StageManager.INSTANCE.initStage(stage);
        StageManager.INSTANCE.loadScene("welcome");


//         stage.setTitle("Home");
//         Parent home = FXMLLoader.load(getClass().getResource("/views/notification.fxml"));
//         Scene scene = new Scene(home);
//         stage.setScene(scene);
//         stage.setResizable(false);




        // stage.setTitle("Home");
        // Parent home = FXMLLoader.load(getClass().getResource("/views/notification.fxml"));
        // Scene scene = new Scene(home);
        // stage.setScene(scene);
        // stage.setResizable(false);

        stage.show();
    }
}