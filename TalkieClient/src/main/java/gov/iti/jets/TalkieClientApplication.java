package gov.iti.jets;

import gov.iti.jets.manager.StageManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class TalkieClientApplication extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        StageManager.INSTANCE.initStage(stage);
        StageManager.INSTANCE.loadScene("welcome");




        // stage.setTitle("Home");
        // Parent home = FXMLLoader.load(getClass().getResource("/views/notification.fxml"));
        // Scene scene = new Scene(home);
        // stage.setScene(scene);
        // stage.setResizable(false);
        stage.show();
    }
}