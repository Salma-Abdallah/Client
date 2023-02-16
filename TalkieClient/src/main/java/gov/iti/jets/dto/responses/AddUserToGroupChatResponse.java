package gov.iti.jets.dto.responses;

import java.io.Serializable;

import gov.iti.jets.models.User;

public class AddUserToGroupChatResponse implements Serializable{
    private User addedUser;
    private String error; //user not on your friend list (Works also if user doesnot exist) ,  user already in group

    AddUserToGroupChatResponse (User addedUser, String error){
        this.addedUser = addedUser;
        this.error = error;
    }
    
    public User getAddedUser() {
        return addedUser;
    }

    public void setAddedUser(User addedUser) {
        this.addedUser = addedUser;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "AddUserToGroupChatResponse [addedUser=" + addedUser + ", error=" + error + "]";
    }

}
