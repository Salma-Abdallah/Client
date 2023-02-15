package gov.iti.jets.dto.responses;

import gov.iti.jets.models.Message;

public class SendMessageResponse {
    private Message message;

    public SendMessageResponse(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SendMessageResponse{" +
                "message=" + message +
                '}';
    }
}
