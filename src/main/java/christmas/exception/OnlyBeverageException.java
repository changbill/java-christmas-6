package christmas.exception;

public class OnlyBeverageException extends CustomException {
    public OnlyBeverageException() {
        super("음료만 주문 시, 주문할 수 없습니다.");
    }
}
