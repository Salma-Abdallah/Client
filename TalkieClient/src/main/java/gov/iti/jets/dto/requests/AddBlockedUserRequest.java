package gov.iti.jets.dto.requests;

public class AddBlockedUserRequest {
    private String userPhoneNumber;
    private String blockedUserPhoneNumber;

    public AddBlockedUserRequest() {
    }

    public AddBlockedUserRequest(String userPhoneNumber, String blockedUserPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
        this.blockedUserPhoneNumber = blockedUserPhoneNumber;
    }

    public AddBlockedUserRequest(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getBlockedUserPhoneNumber() {
        return blockedUserPhoneNumber;
    }

    public void setBlockedUserPhoneNumber(String blockedUserPhoneNumber) {
        this.blockedUserPhoneNumber = blockedUserPhoneNumber;
    }

    @Override
    public String toString() {
        return "AddBlockedUser{" +
                "userPhoneNumber='" + userPhoneNumber + '\'' +
                ", blockedUserPhoneNumber='" + blockedUserPhoneNumber + '\'' +
                '}';
    }
}
