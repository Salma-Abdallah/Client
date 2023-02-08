package gov.iti.jets.network.controllers;

import gov.iti.jets.dto.requests.LoginRequest;
import gov.iti.jets.dto.requests.RegisterRequest;
import gov.iti.jets.dto.responses.LoginResponse;
import gov.iti.jets.dto.responses.RegisterResponse;
import gov.iti.jets.models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuthenticationController extends Remote {

    LoginResponse login(LoginRequest loginRequest) throws RemoteException;
    RegisterResponse register(RegisterRequest registerRequest) throws RemoteException;
    void logout(User user) throws  RemoteException;
}
