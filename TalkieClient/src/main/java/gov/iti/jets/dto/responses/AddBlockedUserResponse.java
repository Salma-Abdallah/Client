package gov.iti.jets.dto.responses;

import gov.iti.jets.models.BlockList;

public class AddBlockedUserResponse {
    private BlockList blockList;

    public AddBlockedUserResponse() {
    }

    public AddBlockedUserResponse(BlockList blockList) {
        this.blockList = blockList;
    }

    public BlockList getBlockList() {
        return blockList;
    }

    public void setBlockList(BlockList blockList) {
        this.blockList = blockList;
    }

    @Override
    public String toString() {
        return "AddBlockedUserResponse{" +
                "blockList=" + blockList +
                '}';
    }
}
