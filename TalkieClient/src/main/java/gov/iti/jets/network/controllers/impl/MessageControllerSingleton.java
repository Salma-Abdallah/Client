package gov.iti.jets.network.controllers.impl;

import gov.iti.jets.network.controllers.MessageController;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageControllerSingleton extends UnicastRemoteObject implements MessageController {

    private static MessageControllerSingleton instance;
    private MessageControllerSingleton() throws RemoteException {}
    public static MessageControllerSingleton getInstance(){
        try {
            if(instance == null){
                instance = new MessageControllerSingleton();
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }

    @Override
    public void send() throws RemoteException{
        System.out.println("SENT: Called from server");
    }

    @Override
    public void receive() throws RemoteException {
        System.out.println("RECEIVED: Called from server");
    }
}
