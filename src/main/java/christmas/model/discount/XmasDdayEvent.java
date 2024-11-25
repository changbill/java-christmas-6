package christmas.model.discount;

import christmas.constant.UtecoDiscountDate;
import java.time.LocalDate;
import java.time.Period;

public class XmasDdayEvent {
    private static final int startDiscountAmount = 1_000;
    private static final int discountIncreaseUnit = 100;

    private int discountAmount = 0;

    public XmasDdayEvent(LocalDate targetDate) {
        if(UtecoDiscountDate.isXmasDday(targetDate)) {
            Period period = Period.between(UtecoDiscountDate.XMAS_D_DAY_DISCOUNT.getStartDate(), targetDate);
            discountAmount = startDiscountAmount + period.getDays() * discountIncreaseUnit;
        }
    }
}
