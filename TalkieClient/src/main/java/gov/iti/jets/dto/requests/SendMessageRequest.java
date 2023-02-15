package gov.iti.jets.dto.requests;

import gov.iti.jets.models.Message;

public class SendMessageRequest {
    private Message message;

    public SendMessageRequest(Message message) {
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
        return "SendMessageRequest{" +
                "message=" + message +
                '}';
    }
}
