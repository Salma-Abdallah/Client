package gov.iti.jets.dto.responses;

import gov.iti.jets.models.Contact;

import java.io.Serializable;
import java.util.List;

public class ContactResponse implements Serializable {

    private static final long serialVersionUID= 546321469785312L;
    private String category;
    private List<Contact> contactList;
    private int result;
    private String phoneNumber;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }


    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }


    public ContactResponse(int result){
        this.result= result;
    }
    public ContactResponse(List<Contact>contactList){
        this.contactList= contactList;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
    public String toString() {
        return "FriendReqRequest" +
                "phoneNumber='" + phoneNumber + '\'' +
                "category='" + category + '\'' +
                '}';
    }
}
