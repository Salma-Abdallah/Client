package gov.iti.jets.dto;

import java.sql.Timestamp;

public class FriendRequestDTO {

    private int id;
    private int senderId;
    private int receiverId;
    private boolean status;
    private Timestamp sentAt;


    public FriendRequestDTO(int id, int senderId, int receiverId, boolean status, Timestamp sentAt) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.status = status;
        this.sentAt = sentAt;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getSentAt() {
        return sentAt;
    }

    public void setSentAt(Timestamp sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public String toString() {
        return "FriendRequestDTO{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", status=" + status +
                ", sentAt=" + sentAt +
                '}';
    }
}