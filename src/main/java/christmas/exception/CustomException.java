package christmas.exception;

import static christmas.exception.ExceptionMessage.ERROR_HEADER;

public class CustomException extends IllegalArgumentException {
    public CustomException(String message) {
        super(ERROR_HEADER + message);
    }
}
