package Kursach.Kursach_2.Exception;

public class BadAddException extends RuntimeException {
    public BadAddException() {
    }

    public BadAddException(String message) {
        super(message);
    }

    public BadAddException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadAddException(Throwable cause) {
        super(cause);
    }
}
