package christmas.model.discount;

import static christmas.constant.UtecoDiscountConstant.DAY_OF_THE_WEEK_DISCOUNT_UNIT_PER_MENU;
import static christmas.constant.UtecoDiscountConstant.STAR_DISCOUNT_AMOUNT;

import christmas.constant.UtecoDiscountDate;
import christmas.constant.UtecoMenuType;
import christmas.model.Orders;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class NewYearEvent {
    private final LocalDate date;
    private final Orders orders;

    private NewYearEvent(Orders orders) {
        date = orders.getOrderDate();
        this.orders = orders;
    }

    static NewYearEvent of(Orders orders) {
        if(UtecoDiscountDate.isNewYear(orders.getOrderDate())) {
            return new NewYearEvent(orders);
        }

        return null;
    }

    public int getWeekdaysDiscount() {
        if(!isWeekend()) {
            return orders.getMenuTypeCount(UtecoMenuType.DESSERT) * DAY_OF_THE_WEEK_DISCOUNT_UNIT_PER_MENU;
        }

        return 0;
    }

    public int getWeekendsDiscount() {
        if(isWeekend()) {
            return orders.getMenuTypeCount(UtecoMenuType.MAIN) * DAY_OF_THE_WEEK_DISCOUNT_UNIT_PER_MENU;
        }

        return 0;
    }

    public int getSpecialDiscount() {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if(dayOfWeek.equals(DayOfWeek.SUNDAY) || date.isEqual(LocalDate.of(2023, 12, 25))) {
            return STAR_DISCOUNT_AMOUNT;
        }

        return 0;
    }

    public boolean isPresentChampagne() {
        return orders.getTotalOrderAmount() >= 120_000;
    }

    private boolean isWeekend() {
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }
}
