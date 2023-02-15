package gov.iti.jets.dto.responses;

public class RemovedBlockedUserResponse {

    private int result;

    public RemovedBlockedUserResponse() {
    }

    public RemovedBlockedUserResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RemovedBlockedUserResponse{" +
                "result=" + result +
                '}';
    }
}
