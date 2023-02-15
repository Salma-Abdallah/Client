package gov.iti.jets.dto.requests;

import java.io.Serializable;

public class RefuseFriendRequest implements Serializable {
    private String friendPhoneNumber;

    public RefuseFriendRequest(String friendPhoneNumber, String userPhoneNumber) {
        this.friendPhoneNumber = friendPhoneNumber;
        this.userPhoneNumber = userPhoneNumber;
    }

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

    @Override
    public String toString() {
        return "RefuseFriendRequest{" +
                "friendPhoneNumber='" + friendPhoneNumber + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                '}';
    }

}
