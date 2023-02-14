package gov.iti.jets.network.controllers;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallbackController extends Remote {

    void respond() throws RemoteException;

}
