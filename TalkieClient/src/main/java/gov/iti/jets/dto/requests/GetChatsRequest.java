package gov.iti.jets.dto.requests;

import java.io.Serializable;

public class GetChatsRequest implements Serializable{
    private static final long serialVersionUID = -0000000000000L;/////////to be ditted
    private String phoneNumber;

    public GetChatsRequest(){}

    public GetChatsRequest(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "GetChatsRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
