package gov.iti.jets.dto.requests;

import java.io.Serializable;

public class LoadFriendReqRequest implements Serializable {
    private static final long serialVersionUID = 213930628588567517L;

    private String userPhoneNumber;
    public LoadFriendReqRequest (){}

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }



    public LoadFriendReqRequest(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
    public String toString() {
        return "LoadFriendRequest" +
                "userPhoneNumber='" + userPhoneNumber + '\'' +
                '}';
    }

}
