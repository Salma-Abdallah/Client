package gov.iti.jets.network.controllers;

import gov.iti.jets.models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserController extends Remote {

    User register(User user) throws RemoteException;

    User edit(User user) throws RemoteException;

    void sendMessage(MessageController messageController) throws RemoteException;
}
