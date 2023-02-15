package gov.iti.jets.network.controllers;

import gov.iti.jets.dto.requests.GetMessagesRequest;
import gov.iti.jets.dto.requests.SendMessageRequest;
import gov.iti.jets.dto.responses.GetMessagesResponse;
import gov.iti.jets.dto.responses.SendMessageResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageController extends Remote {

    GetMessagesResponse getAllMessages(GetMessagesRequest request) throws RemoteException;
    
    SendMessageResponse sendMessage(SendMessageRequest request) throws RemoteException;
}
