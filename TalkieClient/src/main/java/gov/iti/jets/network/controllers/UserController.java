package gov.iti.jets.network.controllers;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gov.iti.jets.dto.UserDTO;

public interface UserController extends Remote {

    UserDTO register(UserDTO user) throws RemoteException;
    UserDTO edit(UserDTO user) throws RemoteException;

    void sendMessage(MessageController messageController) throws RemoteException;
}
