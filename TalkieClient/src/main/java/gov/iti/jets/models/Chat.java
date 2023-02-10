package gov.iti.jets.models;

import java.io.Serializable;

public class Chat implements Serializable{
    String chatId;

    public Chat(){}
    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

}