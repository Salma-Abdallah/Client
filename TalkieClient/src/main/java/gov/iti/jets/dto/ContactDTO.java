package gov.iti.jets.dto;

public class ContactDTO {
    private int id;
    private int userId;
    private int contactId;
    private String category;

    public ContactDTO(int id, int userId, int contactId, String category) {
        this.id = id;
        this.userId = userId;
        this.contactId = contactId;
        this.category = category;
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

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", contactId=" + contactId +
                ", category='" + category + '\'' +
                '}';
    }
}