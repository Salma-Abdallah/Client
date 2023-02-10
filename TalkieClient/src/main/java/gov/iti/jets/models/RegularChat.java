package gov.iti.jets.models;

public class RegularChat extends Chat{
    
    private User firstParticipantId;
    private User secondParticipantId;

    public RegularChat(String chatId, User firstParticipantId, User secondParticipantId) {
        this.chatId = chatId;
        this.firstParticipantId = firstParticipantId;
        this.secondParticipantId = secondParticipantId;
    }

    public RegularChat(String chatId, User firstParticipantId) {
        this.chatId = chatId;
        this.firstParticipantId = firstParticipantId;
    } 

    public void setFirstParticipantId(User firstParticipantId) {
        this.firstParticipantId = firstParticipantId;
    }

    public void setSecondParticipantId(User secondParticipantId) {
        this.secondParticipantId = secondParticipantId;
    }

    public User getFirstParticipantId() {
        return firstParticipantId;
    }

    public User getSecondParticipantId() {
        return secondParticipantId;
    }

    @Override
    public String toString() {
        return "RegularChat{" +
                "chatId='" + chatId + '\'' +
                ", firstParticipantId=" + firstParticipantId +
                ", secondParticipantId=" + secondParticipantId +
                '}';
    }
}