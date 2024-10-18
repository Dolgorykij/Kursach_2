package Kursach.Kursach_2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectQuestionAmount extends RuntimeException {
    public IncorrectQuestionAmount() {
    }

    public IncorrectQuestionAmount(String message) {
        super(message);
    }

    public IncorrectQuestionAmount(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectQuestionAmount(Throwable cause) {
        super(cause);
    }
}
