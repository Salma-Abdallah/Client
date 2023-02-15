package gov.iti.jets.dto.requests;


public class ViewBlockListRequest {
    //private static final long serialVersionUID = L;

    private String userPhoneNumber;
    public ViewBlockListRequest() {
    }
    public ViewBlockListRequest(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
}
