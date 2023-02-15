package gov.iti.jets.dto.requests;

public class RemoveBlockedUserRequest {
    private String userPhoneNumber;
    private String blockedUserPhoneNumber;

    public RemoveBlockedUserRequest() {
    }

    public RemoveBlockedUserRequest(String userPhoneNumber, String blockedUserPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
        this.blockedUserPhoneNumber = blockedUserPhoneNumber;
    }

    public RemoveBlockedUserRequest(String userPhoneNumber) {
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
}
