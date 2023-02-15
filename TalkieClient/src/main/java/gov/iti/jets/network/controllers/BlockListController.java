package gov.iti.jets.network.controllers;

import gov.iti.jets.dto.requests.AddBlockedUserRequest;
import gov.iti.jets.dto.requests.RemoveBlockedUserRequest;
import gov.iti.jets.dto.requests.ViewBlockListRequest;
import gov.iti.jets.dto.responses.AddBlockedUserResponse;
import gov.iti.jets.dto.responses.RemovedBlockedUserResponse;
import gov.iti.jets.dto.responses.ViewBlockListResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BlockListController extends Remote {

    AddBlockedUserResponse addBlockUser(AddBlockedUserRequest  request) throws RemoteException;
    public RemovedBlockedUserResponse removeBlockUser(RemoveBlockedUserRequest request) throws RemoteException;
    public ViewBlockListResponse findAllBlockedUsersByUserId(ViewBlockListRequest request) throws RemoteException;


}
