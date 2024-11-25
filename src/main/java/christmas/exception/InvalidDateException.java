package christmas.exception;

import static christmas.exception.ExceptionMessage.INVALID_DATE;

public class InvalidDateException extends CustomException {
    public InvalidDateException() {
        super(INVALID_DATE);
    }
}
