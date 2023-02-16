package gov.iti.jets.dto.requests;

import java.io.Serializable;

public class CreateGroupChatRequest implements Serializable{
    private String userPhoneNumber;
    private String chatName;

    public CreateGroupChatRequest(String userPhoneNumber, String chatName){
        this.userPhoneNumber = userPhoneNumber;
        this.chatName = chatName;
    }

    public String getChatName() {
        return chatName;
    }
    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
    
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }
    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    @Override
    public String toString() {
        return "CreateGroupChatRequest [userPhoneNumber=" + userPhoneNumber + ", chatName=" + chatName + "]";
    }
    

    
}
