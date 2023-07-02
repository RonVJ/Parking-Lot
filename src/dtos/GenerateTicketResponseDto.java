package dtos;

public class GenerateTicketResponseDto {
    private Long ticketId;
    private String operatorName;
    private Long spotNumber;
    private ResponseStatus responseStatus;
    private String message;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Long getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(Long spotNumber) {
        this.spotNumber = spotNumber;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
