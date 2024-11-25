package christmas.exception;

import static christmas.exception.ExceptionMessage.INVALID_ORDER;

public class InvalidOrderException extends CustomException {
    public InvalidOrderException() {
        super(INVALID_ORDER);
    }
}
