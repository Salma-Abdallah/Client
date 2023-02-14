package gov.iti.jets.network.controllers.impl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import gov.iti.jets.manager.MainPanelManager;
import gov.iti.jets.models.Chat;
import gov.iti.jets.models.CurrentUser;
import gov.iti.jets.models.GroupChat;
import gov.iti.jets.models.Message;
import gov.iti.jets.models.RegularChat;
import gov.iti.jets.models.User;
import gov.iti.jets.network.controllers.CallbackController;
import gov.iti.jets.network.controllers.OnlineStatusController;
import gov.iti.jets.network.manager.NetworkManager;
import javafx.application.Platform;
import gov.iti.jets.controllers.*;

public class CallBackControllerSingleton extends UnicastRemoteObject implements CallbackController {
    private static CallBackControllerSingleton instance;
    private static boolean isServerConnected = false;
    private CallBackControllerSingleton() throws RemoteException {}
    public static CallBackControllerSingleton getInstance(){
        try {
            if(instance == null){
                instance = new CallBackControllerSingleton();
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
                                CallBackControllerSingleton.getInstance());
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

    public void receiveNewMessage(Message message){
        Platform.runLater(() -> {
            MainPanelManager.INSTANCE.getMessageController().getChatCardController(message.getChatId()).addMessage(message);
            MainPanelManager.INSTANCE.getMessageController().riseChatCard(message.getChatId());
        }); 
    }

    public void createNewRegularChat(RegularChat chat){
        //Used when a friend request sent by me is accepted, or when a person i sent a friend request to sends me one
        Platform.runLater(() -> {
            MainPanelManager.INSTANCE.getMessageController().addRegularChat(chat);
        });
    }

    public void addMetoGroupChat(GroupChat chat){
        //Used when some one adds me to an existing groupChat
        Platform.runLater(() -> {
            MainPanelManager.INSTANCE.getMessageController().addGroupChat(chat);
        });
    }

}
