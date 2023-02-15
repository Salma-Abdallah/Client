package gov.iti.jets.dto.requests;

import java.io.Serializable;

public class AcceptFriendRequest implements Serializable {


    private static final long serialVersionUID = -3339255849433394L;

    public AcceptFriendRequest(String friendPhoneNumber, String userPhoneNumber) {
        this.friendPhoneNumber = friendPhoneNumber;
        this.userPhoneNumber = userPhoneNumber;
    }
    public AcceptFriendRequest(){}
    private String friendPhoneNumber;

    private String userPhoneNumber;
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getFriendPhoneNumber() {
        return friendPhoneNumber;
    }

    public void setFriendPhoneNumber(String friendPhoneNumber) {
        this.friendPhoneNumber = friendPhoneNumber;
    }


    public String toString() {
        return "AcceptFriendRequest" +
                "userPhoneNumber='" + userPhoneNumber + '\'' +
                "friendPhoneNumber='" + friendPhoneNumber + '\'' +
                '}';
    }
}



