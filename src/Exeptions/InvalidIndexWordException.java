package Exeptions;



public class InvalidIndexWordException extends RuntimeException {
    private final String message;

    public InvalidIndexWordException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String toString() {
        return getMessage();
    }
}
