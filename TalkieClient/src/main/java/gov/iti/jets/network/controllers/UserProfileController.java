package gov.iti.jets.network.controllers;

import gov.iti.jets.dto.requests.UserProfileRequest;
import gov.iti.jets.dto.responses.UserProfileResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserProfileController extends Remote {
    UserProfileResponse update (UserProfileRequest request) throws RemoteException;
}
