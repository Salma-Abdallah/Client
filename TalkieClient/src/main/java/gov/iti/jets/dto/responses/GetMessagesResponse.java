package gov.iti.jets.dto.responses;

import java.io.Serializable;
import java.util.List;

import gov.iti.jets.models.Message;

public class GetMessagesResponse implements Serializable{
    private static final long serialVersionUID = 9043423763656167576L;

    private List<Message> messageList;

    public GetMessagesResponse(){}

    public GetMessagesResponse(List<Message> messageList){
        this.messageList=messageList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    @Override
    public String toString() {
        return "GetMessagesResponse{" +
                "MessagesList='" + messageList.size() + '\'' +
                '}';
    }
}
