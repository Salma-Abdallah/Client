package gov.iti.jets.dto.responses;

import gov.iti.jets.models.RegularChat;
import java.io.Serializable;

public class AcceptFriendResponse implements Serializable {
    private RegularChat regularChat;


   public AcceptFriendResponse(RegularChat regularChat){
       this.regularChat = regularChat;
   }



   public RegularChat getRegularChat() {
        return regularChat;
    }

    public void setRegularChat(RegularChat regularChat) {
        this.regularChat = regularChat;
    }




    @Override
    public String toString() {
        return "AcceptFriendRequest{" +
                "regularChat=" + regularChat +
                '}';
    }
}
