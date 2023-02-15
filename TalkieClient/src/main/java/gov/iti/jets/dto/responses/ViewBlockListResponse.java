package gov.iti.jets.dto.responses;

import gov.iti.jets.models.BlockList;
import gov.iti.jets.models.User;

import java.util.List;

public class ViewBlockListResponse {
    private BlockList blockList;
    private int deleteResult;
    private List<User> userList;

    public ViewBlockListResponse(BlockList blockList, int deleteResult, List<User> userList) {
        this.blockList = blockList;
        this.deleteResult = deleteResult;
        this.userList = userList;
    }

    public ViewBlockListResponse(BlockList blockList) {
        this.blockList = blockList;
    }

    public ViewBlockListResponse(int deleteResult) {
        this.deleteResult = deleteResult;
    }

    public ViewBlockListResponse(List<User> userList) {
        this.userList = userList;
    }

    public BlockList getBlockList() {
        return blockList;
    }

    public void setBlockList(BlockList blockList) {
        this.blockList = blockList;
    }

    public int getDeleteResult() {
        return deleteResult;
    }

    public void setDeleteResult(int deleteResult) {
        this.deleteResult = deleteResult;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String  toString() {
        return "BlockListResponse{" +
                "blockList=" + blockList +
                ", deleteResult=" + deleteResult +
                ", userList=" + userList +
                '}';
    }
}
