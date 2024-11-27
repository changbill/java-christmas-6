package christmas.constant.print;

public enum BenefitDetailsConstant {
    XMAS_D_DAY_DISCOUNT_DESCRIPTION("크리스마스 디데이 할인"),
    WEEKDAYS_DISCOUNT_DESCRIPTION("평일 할인"),
    WEEKENDS_DISCOUNT_DESCRIPTION("주말 할인"),
    SPECIAL_DISCOUNT_DESCRIPTION("특별 할인"),
    FREE_CHAMPAGNE_DESCRIPTION("증정 이벤트"),
    ;

    private final String description;

    BenefitDetailsConstant(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
