package gov.iti.jets.dto.responses;

import java.io.Serializable;

public class ChangeUserStatusResponse implements Serializable{
    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ChangeUserStatusResponse(Boolean success){
        this.success = success;
    }

    @Override
    public String toString() {
        return "ChangeUserStatusResponse [success=" + success + "]";
    }
}
