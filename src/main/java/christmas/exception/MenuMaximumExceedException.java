package christmas.exception;

public class MenuMaximumExceedException extends CustomException {
    public MenuMaximumExceedException() {
        super("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
    }
}
