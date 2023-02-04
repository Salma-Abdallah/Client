package gov.iti.jets.manager;

// import gov.iti.jets.TalkieClientApplication;
import gov.iti.jets.controllers.FXMLController;
import gov.iti.jets.controllers.FXMLControllerFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public enum MainPanelManager {
    INSTANCE;
    private HBox root;
    private VBox sideBar;
    private VBox contacts;
    private final Map<String, SplitPane> contentLayouts = new HashMap<>();
    private final Map<String, FXMLController> controllers = new HashMap<>();
    public HBox setup(HBox root) {
        if(this.root != null){
            loadContent("default-content");
            // throw new RuntimeException("Root layout already initialized");
        }
        this.root = root;
        try {
            FXMLLoader loader = new FXMLLoader();
            FXMLController sideBarController = FXMLControllerFactory.getController("side-bar");//////////////////
            loader.setController(sideBarController);///////////////////
            sideBar = loader.load(getClass().getClassLoader().getResource("views/components/side-bar.fxml").openStream());////////////////////////////
            controllers.put("side-bar", sideBarController);

            FXMLLoader loader2 = new FXMLLoader();
            FXMLController messagesController = FXMLControllerFactory.getController("message");//////////////////
            loader2.setController(messagesController);///////////////////
            contacts = loader2.load(getClass().getClassLoader().getResource("views/components/message.fxml").openStream()); //views/components/message.fxml
            controllers.put("message", messagesController);

            loadContent("default-content");///most recent messag!
            root.getChildren().set(0, sideBar);
            root.getChildren().set(1, contacts);
        } catch (IOException e) {
            e.printStackTrace();
            // throw new RuntimeException(e);
        }
        return root;
    }
    public FXMLController loadContent(String name){
        if(root == null){
            throw new RuntimeException("Initialize the root pane first");
        }
        if(!contentLayouts.containsKey(name)){
            try {
                System.out.println("New tab " + name);
                FXMLLoader loader = new FXMLLoader();
                FXMLController controller = FXMLControllerFactory.getController(name);
                loader.setController(controller);
                System.out.println(getClass().getClassLoader().getResource(String.format("views/content/%s.fxml", name)));
                SplitPane content = loader.load(getClass().getClassLoader().getResource(String.format("views/content/%s.fxml", name)).openStream());/////////////////
                if(name=="chatting-panel")
                contentLayouts.put(name, content);
                controllers.put(name, controller);
                root.getChildren().set(2, content);
                HBox.setHgrow(root.getChildren().get(2), Priority.ALWAYS);
                return controller;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
                // e.printStackTrace();
            }
        }
        else{
            System.out.println("Same Tab " +  name);
            root.getChildren().set(2, contentLayouts.get(name));
            HBox.setHgrow(root.getChildren().get(2), Priority.ALWAYS);
            return controllers.get(name);
        }
    }
    public VBox getSideBar() {
        return sideBar;
    }
    public VBox getContacts() {
        return contacts;
    }
}
