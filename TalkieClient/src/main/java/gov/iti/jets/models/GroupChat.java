package gov.iti.jets.models;

import java.util.List;

public class GroupChat extends Chat{

    private User owner;
    private String name;
    private List<User> participants;
    
    public GroupChat(String chatId, User owner, String name, List<User> participants) {
        this.chatId = chatId;
        this.owner = owner;
        this.name = name;
        this.participants = participants;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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

    @Override
    public String toString() {
        return "GroupChat{" +
                "chatId='" + chatId + '\'' +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                ", participants=" + participants +
                '}';
    }
}