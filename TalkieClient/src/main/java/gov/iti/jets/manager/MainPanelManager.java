package gov.iti.jets.manager;

// import gov.iti.jets.TalkieClientApplication;
import gov.iti.jets.controllers.FXMLController;
import gov.iti.jets.controllers.FXMLControllerFactory;
import gov.iti.jets.controllers.FriendRequestsController;
import gov.iti.jets.controllers.MessageControllerFXML;
import gov.iti.jets.models.Chat;
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
    private final Map<String, SplitPane> contentsLayouts = new HashMap<>(); ///should be deleted on logout
    private final Map<String, FXMLController> componentsControllers = new HashMap<>();

    public HBox setup(HBox root) {
        if(this.root != null){
            loadContent("default-content");
            // throw new RuntimeException("Root layout already initialized");
        }
        this.root = root;
        try {
            FXMLLoader sideBarLoader = new FXMLLoader();
            FXMLController sideBarController = FXMLControllerFactory.getController("side-bar");//////////////////
            sideBarLoader.setController(sideBarController);///////////////////
            sideBar = sideBarLoader.load(getClass().getClassLoader().getResource("views/components/side-bar.fxml").openStream());////////////////////////////
            componentsControllers.put("side-bar", sideBarController);

            FXMLLoader messagesPanelLoader = new FXMLLoader();
            FXMLController messagesController = FXMLControllerFactory.getController("message");//////////////////
            messagesPanelLoader.setController(messagesController);///////////////////
            contacts = messagesPanelLoader.load(getClass().getClassLoader().getResource("views/components/message.fxml").openStream()); //views/components/message.fxml
            componentsControllers.put("message", messagesController);

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
        if(!contentsLayouts.containsKey(name)){
            try {
                System.out.println("New tab " + name);
                FXMLLoader loader = new FXMLLoader();
                FXMLController controller = FXMLControllerFactory.getController(name);
                loader.setController(controller);
                SplitPane content = loader.load(getClass().getClassLoader().getResource(String.format("views/content/%s.fxml", name)).openStream());/////////////////
                
                // if(name=="chatting-panel") 
                contentsLayouts.put(name, content);//???????????
                componentsControllers.put(name, controller);
                root.getChildren().set(2, content);
                HBox.setHgrow(root.getChildren().get(2), Priority.ALWAYS);//???????????????
                return controller;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
                // e.printStackTrace();
            }
        }
        else{
            System.out.println("Same Tab " +  name);
            root.getChildren().set(2, contentsLayouts.get(name));
            HBox.setHgrow(root.getChildren().get(2), Priority.ALWAYS);
            return componentsControllers.get(name);
        }
    }
    public VBox getSideBar() {
        return sideBar;
    }
    public VBox getContacts() {
        return contacts;
    }

    public MessageControllerFXML getMessageController(){
        return (MessageControllerFXML)componentsControllers.get("message");
    }
    
    public FriendRequestsController getFriendRequestsController(){
        if(componentsControllers.get("friend-request")!=null)
            return (FriendRequestsController)componentsControllers.get("friend-request");
        else {
            //     FXMLLoader loader = new FXMLLoader();
            //     FXMLController controller = FXMLControllerFactory.getController("friend-request");
            // try {
            //     loader.setController(controller);
            //     SplitPane content = loader.load(getClass().getClassLoader().getResource("views/content/friend-request.fxml").openStream());
            //     contentsLayouts.put("friend-request", content);
            //     componentsControllers.put("friend-request", controller);
            // } catch (IOException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }
            // return (FriendRequestsController)controller; 
            return null;   
        }
    }
    // public void loadChatInfo(Chat chat){
    //     if(componentsControllers.containsKey("chatting-panel")){

    //     }
    // }
}
