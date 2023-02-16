package gov.iti.jets.network.controllers;

import gov.iti.jets.dto.requests.AddUserToGroupChatRequest;
import gov.iti.jets.dto.requests.CreateGroupChatRequest;
import gov.iti.jets.dto.requests.GetChatsRequest;
import gov.iti.jets.dto.responses.AddUserToGroupChatResponse;
import gov.iti.jets.dto.responses.CreateGroupChatResponse;
import gov.iti.jets.dto.responses.GetChatsResponse;
import gov.iti.jets.models.Chat;
import gov.iti.jets.models.RegularChat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatController extends Remote {
    GetChatsResponse getAllChat(GetChatsRequest request) throws RemoteException;
    CreateGroupChatResponse createGroupChat(CreateGroupChatRequest request) throws RemoteException;
    public AddUserToGroupChatResponse addUserToGroupChat(AddUserToGroupChatRequest request) throws RemoteException;
}
