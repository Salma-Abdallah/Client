package gov.iti.jets.network.controllers;

import gov.iti.jets.dto.requests.ContactRequest;
import gov.iti.jets.dto.responses.ContactResponse;
import gov.iti.jets.models.Contact;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ContactController extends Remote {

    ContactResponse addNewContact(ContactRequest contactRequest) throws RemoteException;
    ContactResponse getContactsByUserID(ContactRequest contactRequest) throws RemoteException;
    ContactResponse deleteContact(ContactRequest contactRequest) throws RemoteException;

}
