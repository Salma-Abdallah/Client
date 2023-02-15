package gov.iti.jets.dto.requests;

import java.io.Serializable;

public class ContactRequest implements Serializable {

    private static final long serialVersionUID= -666612345432594L;
    private String category;
    private String userPhoneNumber;
    private String contactPhoneNumber;


    public ContactRequest() {}


    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
    public String toString() {
        return "FriendReqRequest" +
                "phoneNumber='" + userPhoneNumber + '\'' +
                "category='" + category + '\'' +
                '}';
    }


}
