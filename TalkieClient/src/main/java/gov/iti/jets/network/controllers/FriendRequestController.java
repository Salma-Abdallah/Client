package gov.iti.jets.network.controllers;

import gov.iti.jets.dto.requests.AcceptFriendRequest;
import gov.iti.jets.dto.requests.CancelFriendRequest;
import gov.iti.jets.dto.requests.LoadFriendReqRequest;
import gov.iti.jets.dto.requests.RefuseFriendRequest;
import gov.iti.jets.dto.requests.SendFriendReqRequest;
import gov.iti.jets.dto.responses.AcceptFriendResponse;
import gov.iti.jets.dto.responses.CancelFriendRequestResponse;
// import gov.iti.jets.dto.responses.FriendReqResponse;
import gov.iti.jets.dto.responses.LoadFriendReqResponse;
import gov.iti.jets.dto.responses.RefuseFriendFriendResponse;
import gov.iti.jets.dto.responses.SendFriendReqResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FriendRequestController extends Remote {


    SendFriendReqResponse sendFriendRequest (SendFriendReqRequest sendFriendReqRequest) throws  RemoteException;
    CancelFriendRequestResponse cancel (CancelFriendRequest cancelFriendRequest) throws RemoteException;
    RefuseFriendFriendResponse refuse (RefuseFriendRequest refuseFriendRequest) throws RemoteException;
    AcceptFriendResponse accept (AcceptFriendRequest acceptFriendRequest) throws  RemoteException;
    LoadFriendReqResponse getSentFriendRequestByUserID (LoadFriendReqRequest loadFriendReqRequest)throws RemoteException;
    LoadFriendReqResponse getReceivedFriendReqByUserID(LoadFriendReqRequest loadFriendReqRequest) throws RemoteException;




}
