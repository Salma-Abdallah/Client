package gov.iti.jets.dto.responses;

import gov.iti.jets.dto.requests.LoadFriendReqRequest;
import gov.iti.jets.models.FriendRequest;

import java.io.Serializable;
import java.util.List;

public class LoadFriendReqResponse implements Serializable {
    private List<FriendRequest> receivedFriendRequestList;

    public LoadFriendReqResponse( List<FriendRequest> FriendRequestList) {
        this.receivedFriendRequestList = FriendRequestList;
    }

    public List<FriendRequest> getReceivedFriendRequestList() {
        return receivedFriendRequestList;
    }

    public void setReceivedFriendRequestList(List<FriendRequest> receivedFriendRequestList) {
        this.receivedFriendRequestList = receivedFriendRequestList;
    }



}