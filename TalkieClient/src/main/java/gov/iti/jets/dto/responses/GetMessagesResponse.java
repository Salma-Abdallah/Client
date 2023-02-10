package gov.iti.jets.dto.responses;

import java.io.Serializable;
import java.util.List;

import gov.iti.jets.models.Messages;

public class GetMessagesResponse implements Serializable{
    private static final long serialVersionUID = 0000000000000000L; //to be changed

    private List<Messages> MessagesList;

    public GetMessagesResponse(){}

    public GetMessagesResponse(List<Messages> MessagesListList){
        this.MessagesList=MessagesListList;
    }

    public List<Messages> getMessagesListList() {
        return MessagesList;
    }

    @Override
    public String toString() {
        return "GetMessagesResponse{" +
                "MessagesList='" + MessagesList.size() + '\'' +
                '}';
    }
}
