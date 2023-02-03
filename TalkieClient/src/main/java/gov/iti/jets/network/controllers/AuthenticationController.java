package gov.iti.jets.network.controllers;

import gov.iti.jets.models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuthenticationController extends Remote {

    User authenticate(User user) throws RemoteException;
}
