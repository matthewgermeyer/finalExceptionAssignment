//For the CannotAppendException also have another constructor with 2 parameters - a String and a Throwable cause.

public class CannotAppendException extends Exception{

    public CannotAppendException(String message) {
        super(message);
    }

    public CannotAppendException(String message, Throwable cause) {
        super(message, cause);
    }
}
