package gov.iti.jets.dto;

public class BlockListDTO {
    private int id;
    private int userId;
    private int blockedUserId;

    public BlockListDTO(int id, int userId, int blockedUserId) {
        this.id = id;
        this.userId = userId;
        this.blockedUserId = blockedUserId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlockedUserId() {
        return blockedUserId;
    }

    public void setBlockedUserId(int blockedUserId) {
        this.blockedUserId = blockedUserId;
    }
}
