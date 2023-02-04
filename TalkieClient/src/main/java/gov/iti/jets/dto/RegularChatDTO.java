package gov.iti.jets.dto;
public class RegularChatDTO {
    private String id;
    private int firstParticipantId;
    private int secondParticipantId;

    public RegularChatDTO(String id, int firstParticipantId, int secondParticipantId) {
        this.id = id;
        this.firstParticipantId = firstParticipantId;
        this.secondParticipantId = secondParticipantId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFirstParticipantId() {
        return firstParticipantId;
    }

    public void setFirstParticipantId(int firstParticipantId) {
        this.firstParticipantId = firstParticipantId;
    }

    public int getSecondParticipantId() {
        return secondParticipantId;
    }

    public void setSecondParticipantId(int secondParticipantId) {
        this.secondParticipantId = secondParticipantId;
    }
}