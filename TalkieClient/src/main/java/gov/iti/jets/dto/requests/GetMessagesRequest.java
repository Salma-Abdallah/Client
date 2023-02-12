package gov.iti.jets.dto.requests;

import java.io.Serializable;

import gov.iti.jets.models.Chat;

public class GetMessagesRequest implements Serializable{
    private static final long serialVersionUID = 213930628588567517L;
    private String phoneNumber;
    private String chatId;

    public GetMessagesRequest(){}

    public GetMessagesRequest(Chat chat){
        this.chatId = chat.getChatId();
    }

    @Override
    public String toString() {
        return "GetMessagesRequest{" +
                "chatId='" + chatId + '\'' +
                '}';
    }
}
