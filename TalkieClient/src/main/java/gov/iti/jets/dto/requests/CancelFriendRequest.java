package gov.iti.jets.dto.requests;

import java.io.Serializable;

public class CancelFriendRequest implements Serializable {

    private String friendPhoneNumber;


    private String userPhoneNumber;
     public CancelFriendRequest(String friendPhoneNumber, String userPhoneNumber) {
        this.friendPhoneNumber = friendPhoneNumber;
        this.userPhoneNumber = userPhoneNumber;
    }
    public CancelFriendRequest(){}

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

    @Override
    public String toString() {
        return "CancelFriendRequest{" +
                "friendPhoneNumber='" + friendPhoneNumber + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                '}';
    }

}
