package gov.iti.jets.dto.responses;

import java.io.Serializable;
import java.util.List;

import gov.iti.jets.models.Chat;

public class GetChatsResponse implements Serializable{
    private static final long serialVersionUID = 0000000000000000L; //to be changed

    private List<Chat> allChatsList;

    public GetChatsResponse(){}

    public GetChatsResponse(List<Chat> allChatsList){
        this.allChatsList=allChatsList;
    }

    public List<Chat> getAllChatsList() {
        return allChatsList;
    }

    @Override
    public String toString() {
        return "GetChatsResponse{" +
                "AllChatsCount='" + allChatsList.size() + '\'' +
                '}';
    }
}
