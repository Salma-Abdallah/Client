package gov.iti.jets.dto.responses;

import java.io.Serializable;

public class RefuseFriendFriendResponse implements Serializable {
    private static final long serialVersionUID = -652405811389313082L;

    private String alert;

    @Override
    public String toString() {
        return "RefuseFriendFriendResponse{" +
                "alert='" + alert + '\'' +
                '}';
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public RefuseFriendFriendResponse(String alert) {
        this.alert = alert;
    }
}
