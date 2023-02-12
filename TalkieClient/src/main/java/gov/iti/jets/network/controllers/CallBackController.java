package gov.iti.jets.network.controllers;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallBackController extends Remote {

    void send() throws RemoteException;
    void receive() throws RemoteException;

}
