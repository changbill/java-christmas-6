package christmas.model.discount;

import christmas.constant.discount.UtecoDiscountDate;
import java.time.LocalDate;
import java.time.Period;

public class XmasDdayEvent {
    private static final int startDiscountAmount = 1_000;
    private static final int discountIncreaseUnit = 100;

    private final LocalDate date;

    private XmasDdayEvent(LocalDate date) {
        this.date = date;
    }

    public static XmasDdayEvent of(LocalDate date) {
        if (UtecoDiscountDate.isXmasDday(date)) {
            return new XmasDdayEvent(date);
        }

        return null;
    }

    public int getXmasDdayDiscount() {
        Period period = Period.between(UtecoDiscountDate.XMAS_D_DAY_DISCOUNT.getStartDate(), date);
        return -(startDiscountAmount + period.getDays() * discountIncreaseUnit);
    }
}
