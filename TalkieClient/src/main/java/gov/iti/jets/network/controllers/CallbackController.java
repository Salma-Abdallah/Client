package gov.iti.jets.network.controllers;

import java.rmi.Remote;
import java.rmi.RemoteException;

import gov.iti.jets.models.FriendRequest;
import gov.iti.jets.models.GroupChat;
import gov.iti.jets.models.Message;
import gov.iti.jets.models.RegularChat;
import gov.iti.jets.models.User;

public interface CallbackController extends Remote {

    void respond() throws RemoteException;
    // Send Message to other participants in chat
    void receiveNewMessage(Message message) throws RemoteException;

    // When someone changes status notify friends.
    void friendOnlineStatus(String chatId, String status) throws RemoteException;
    // when a sent friendrequest is accepted new chat is initialized (in save function in FRController).
    void createNewRegularChat(RegularChat chat) throws RemoteException;

    // When someone is added to a groupchat this is called so that the group chat appears on this person's panel.
    void addCurrentUserToGroupChat(GroupChat chat) throws RemoteException;

    void createNewFriendRequest(FriendRequest friendRequest) throws RemoteException;


    // when a notification is sent on broadcast to all online users.
    void broadcastNotification(String message) throws RemoteException;

    void deleteRecievedFriendRequest(String senderPhoneNumber) throws RemoteException;
}
