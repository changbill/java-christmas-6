package christmas.exception;

import static christmas.exception.ExceptionMessage.MENU_MAXIMUM_EXCEED;

public class MenuMaximumExceedException extends CustomException {
    public MenuMaximumExceedException() {
        super(MENU_MAXIMUM_EXCEED);
    }
}
