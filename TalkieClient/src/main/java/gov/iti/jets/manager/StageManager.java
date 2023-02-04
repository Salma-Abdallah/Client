package gov.iti.jets.manager;

import gov.iti.jets.controllers.FXMLController;
import gov.iti.jets.controllers.FXMLControllerFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public enum StageManager {
    INSTANCE;
    private Stage primaryStage;
    private final Map<String, Scene> scenes = new HashMap<>();
    private final Map<String, FXMLController> controllers = new HashMap<>();
    public void initStage(Stage stage){
        if(primaryStage != null){
            throw new IllegalArgumentException("The stage has already been initialized");
        }
        primaryStage = stage;
    }

    public FXMLController loadScene(String name) {
        if (primaryStage == null) {
            throw new RuntimeException("Initial stage is required");
        }
        if (!scenes.containsKey(name)){
            try {
                FXMLLoader loader = new FXMLLoader();
                FXMLController controller = FXMLControllerFactory.getController(name);
                loader.setController(controller);
                Scene scene = new Scene(loader.load(getClass().getClassLoader().getResource(String.format("views/stages/%s.fxml", name)).openStream()));
                scenes.put(name, scene);
                controllers.put(name, controller);
                primaryStage.setScene(scene);
                return controller;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            primaryStage.setScene(scenes.get(name));
            return controllers.get(name);
        }
        return null;
    }
}
