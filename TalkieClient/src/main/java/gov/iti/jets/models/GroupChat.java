package gov.iti.jets.models;

import java.util.List;

public class GroupChat {
    private String chatId;
    private User ownerId;
    private String name;
    private List<User> participants;

    public GroupChat(String chatId, User ownerId, String name, List<User> participants) {
        this.chatId = chatId;
        this.ownerId = ownerId;
        this.name = name;
        this.participants = participants;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}