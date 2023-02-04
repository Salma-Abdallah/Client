package gov.iti.jets.network.controllers;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gov.iti.jets.dto.UserDTO;

public interface AuthenticationController extends Remote {

    UserDTO authenticate(UserDTO user) throws RemoteException;
}
