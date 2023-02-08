package gov.iti.jets.models;
public class RegularChat {
    private String chatId;
    private User firstParticipantId;
    private User secondParticipantId;

    public RegularChat(String chatId, User firstParticipantId, User secondParticipantId) {
        this.chatId = chatId;
        this.firstParticipantId = firstParticipantId;
        this.secondParticipantId = secondParticipantId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public void setFirstParticipantId(User firstParticipantId) {
        this.firstParticipantId = firstParticipantId;
    }

    public void setSecondParticipantId(User secondParticipantId) {
        this.secondParticipantId = secondParticipantId;
    }
}