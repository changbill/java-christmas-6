package christmas.model.discount;

import christmas.model.Orders;

public class CalculateDiscount {
    private int weekdaysDiscount = 0;
    private int weekendsDiscount = 0;
    private int specialDiscount = 0;
    private boolean freeChampagne = false;
    private int xmasDdayDiscount = 0;

    private CalculateDiscount(Orders orders) {
        NewYearEvent newYearEvent = NewYearEvent.of(orders);
        if(newYearEvent != null) {
            weekdaysDiscount = newYearEvent.getWeekdaysDiscount();
            weekendsDiscount = newYearEvent.getWeekendsDiscount();
            specialDiscount = newYearEvent.getSpecialDiscount();
            freeChampagne = newYearEvent.isPresentChampagne();
        }

        XmasDdayEvent xmasDdayEvent = XmasDdayEvent.of(orders.getOrderDate());
        if(xmasDdayEvent != null) {
            xmasDdayDiscount = xmasDdayEvent.getXmasDdayDiscount();
        }
    }
    
    public static CalculateDiscount of(Orders orders) {
        return new CalculateDiscount(orders);
    }

    public int getWeekdaysDiscount() {
        return weekdaysDiscount;
    }

    public int getWeekendsDiscount() {
        return weekendsDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public boolean isFreeChampagne() {
        return freeChampagne;
    }

    public int getXmasDdayDiscount() {
        return xmasDdayDiscount;
    }
}
