package gov.iti.jets.network.controllers.impl;

import gov.iti.jets.network.controllers.CallBackController;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallBackControllerSingleton extends UnicastRemoteObject implements CallBackController {

    private static CallBackControllerSingleton instance;
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
    public void send() throws RemoteException{
        System.out.println("SENT: Called from server");
    }

    @Override
    public void receive() throws RemoteException {
        System.out.println("RECEIVED: Called from server");
    }
}
