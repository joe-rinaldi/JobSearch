package BofA;

public class EmployeeResponse {
    String statusCode;
    String message;

    //create constructor
    public EmployeeResponse(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    //create getters and setters
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
