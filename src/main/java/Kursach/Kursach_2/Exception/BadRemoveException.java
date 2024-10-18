package Kursach.Kursach_2.Exception;

public class BadRemoveException extends RuntimeException {
    public BadRemoveException() {
    }

    public BadRemoveException(String message) {
        super(message);
    }

    public BadRemoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRemoveException(Throwable cause) {
        super(cause);
    }
}
