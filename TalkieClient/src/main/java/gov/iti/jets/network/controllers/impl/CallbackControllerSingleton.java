package gov.iti.jets.network.controllers.impl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import gov.iti.jets.manager.MainPanelManager;
import gov.iti.jets.manager.StageManager;
import gov.iti.jets.models.CurrentUser;
import gov.iti.jets.models.FriendRequest;
import gov.iti.jets.models.GroupChat;
import gov.iti.jets.models.Message;
import gov.iti.jets.models.RegularChat;
import gov.iti.jets.models.User;
import gov.iti.jets.network.controllers.CallbackController;
import gov.iti.jets.network.controllers.OnlineStatusController;
import gov.iti.jets.network.manager.NetworkManager;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import gov.iti.jets.controllers.*;

public class CallbackControllerSingleton extends UnicastRemoteObject implements CallbackController {
    private static CallbackControllerSingleton instance;
    private static boolean isServerConnected = false;
    private CallbackControllerSingleton() throws RemoteException {}
    public static CallbackControllerSingleton getInstance(){
        try {
            if(instance == null){
                instance = new CallbackControllerSingleton();
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }

    @Override
    public void respond() throws RemoteException {
        System.out.println("You are still connected");
        isServerConnected = true;
    }

    public void checkServerAvailability(){
        new Thread(()->{
            while (true){
                if(isServerConnected){
                    isServerConnected = false;
                }
                else{
                    System.out.println("Reconnecting");
                    try {
                        OnlineStatusController userController = (OnlineStatusController) NetworkManager.getRegistry().lookup("OnlineStatusController");
                        userController.connect(
                                CurrentUser.getInstance().getUser(),
                                CallbackControllerSingleton.getInstance());
                    } catch (RemoteException e) {
                        System.out.println("Reconnection Failed...");
                    } catch (NotBoundException e) {
                        System.out.println("Reconnection Failed...");
                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    @Override
    public void receiveNewMessage(Message message){
        Platform.runLater(() -> {
            MainPanelManager.INSTANCE.getMessageController().getChatCardController(message.getChatId()).addMessage(message);
            MainPanelManager.INSTANCE.getMessageController().riseChatCard(message.getChatId());
        }); 
    }

    @Override
    public void createNewRegularChat(RegularChat chat){
        //Used when a friend request sent by me is accepted, or when a person i sent a friend request to sends me one
        Platform.runLater(() -> {
            FriendRequestsController friendRequestsController = MainPanelManager.INSTANCE.getFriendRequestsController();
            if(friendRequestsController!=null){
                friendRequestsController.deleteFRCard(chat.getFirstParticipant().getPhoneNumber());
            }
            MainPanelManager.INSTANCE.getMessageController().addRegularChat(chat);
        });
    }

    //TODO////////////////
    @Override
    public void friendOnlineStatus(String chatId, String status){
        Platform.runLater(() -> {
            MainPanelManager.INSTANCE.getMessageController().updateChatStatus(chatId, status);

            NotificationController notificationController = new NotificationController();
            FXMLLoader loader = new FXMLLoader();
            loader.setController(notificationController);
            try {
                Pane pane = loader.load(getClass().getClassLoader().getResource("views/components/notification.fxml").openStream());
                notificationController.setData(MainPanelManager.INSTANCE.getMessageController().getChatNameByChatId(chatId), "just got "+status);
                Popup popup = new Popup();
                popup.getContent().add(pane);
                popup.setAutoHide(true);
                MainAlignmentController mainAlignmentController = (MainAlignmentController)StageManager.INSTANCE.loadScene("main-alignment");
                popup.show(mainAlignmentController.getMainHBox(), 0, 0);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }


    @Override
    public void addCurrentUserToGroupChat(GroupChat chat) throws RemoteException {
        // TODO Auto-generated method stub
        //Used when some one adds me to an existing groupChat
        Platform.runLater(() -> {
            MainPanelManager.INSTANCE.getMessageController().addGroupChat(chat);
        });
    }

    
    //TODO////////////////
    @Override
    public void broadcastNotification(String message) throws RemoteException {
        // TODO Auto-generated method stub
        Platform.runLater(() -> {
            NotificationController notificationController = new NotificationController();
                FXMLLoader loader = new FXMLLoader();
                loader.setController(notificationController);
                try {
                    Pane pane = loader.load(getClass().getClassLoader().getResource("views/components/notification.fxml").openStream());
                    notificationController.setData("Adminstration", message);
                    Popup popup = new Popup();
                    popup.getContent().add(pane);
                    popup.setAutoHide(true);
                    MainAlignmentController mainAlignmentController = (MainAlignmentController)StageManager.INSTANCE.loadScene("main-alignment");
                    popup.show(mainAlignmentController.getMainHBox(), 0, 0);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        });
        
    }
    @Override
    public void createNewFriendRequest(FriendRequest friendRequest) throws RemoteException {
        // TODO Auto-generated method stub
        Platform.runLater(() -> {
            FriendRequestsController controller = MainPanelManager.INSTANCE.getFriendRequestsController();
            if(controller!=null)controller.addRecievedFriendRequest(friendRequest);
        });
    }

    @Override
    public void deleteRecievedFriendRequest(String senderPhoneNumber) throws RemoteException {
        // TODO Auto-generated method stub
        System.out.println(senderPhoneNumber);
        Platform.runLater(() -> {
            FriendRequestsController controller = MainPanelManager.INSTANCE.getFriendRequestsController();
            if(controller!=null){
                System.out.println("Delete     :"+senderPhoneNumber);
                controller.deleteFRCard(senderPhoneNumber);
            }
        });
    }


}
