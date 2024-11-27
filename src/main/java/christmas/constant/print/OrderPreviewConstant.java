package christmas.constant.print;

public enum OrderPreviewConstant {
    ORDER_MENU("<주문 메뉴>", "%s %,d개"),
    TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>", "%,d원"),
    GIVEAWAY_MENU("<증정 메뉴>", "%s %,d개"),
    BENEFIT_DETAILS("<혜택 내역>", "%s: %,d원"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>", "%,d원"),
    ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>", "%,d원"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>", "%s"),
    ;

    private final String header;
    private final String value;

    OrderPreviewConstant(String header, String value) {
        this.header = header;
        this.value = value;
    }

    public String getHeader() {
        return header;
    }

    public String getValue() {
        return value;
    }
}
