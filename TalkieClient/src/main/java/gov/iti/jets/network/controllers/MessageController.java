package gov.iti.jets.network.controllers;

import gov.iti.jets.dto.requests.GetMessagesRequest;
import gov.iti.jets.dto.responses.GetMessagesResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageController extends Remote {

    GetMessagesResponse getAllMessages(GetMessagesRequest request) throws RemoteException;
}
