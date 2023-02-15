package gov.iti.jets.dto.responses;

import java.io.Serializable;

public class CancelFriendRequestResponse implements Serializable {
    private static final long serialVersionUID = -6546150382426913517L;
    private String alert;

    public CancelFriendRequestResponse(String alert) {
        this.alert = alert;
    }
    @Override
    public String toString() {
        return "CancelFriendRequestResponse{" +
                "alert='" + alert + '\'' +
                '}';
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }
}
