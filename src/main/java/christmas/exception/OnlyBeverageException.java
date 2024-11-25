package christmas.exception;

import static christmas.exception.ExceptionMessage.ONLY_BEVERAGE;

public class OnlyBeverageException extends CustomException {
    public OnlyBeverageException() {
        super(ONLY_BEVERAGE);
    }
}
