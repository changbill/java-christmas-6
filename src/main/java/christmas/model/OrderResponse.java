package christmas.model;

import java.time.LocalDate;
import java.util.List;

public class OrderResponse {
    private final List<Order> orderList;
    private final LocalDate orderDate;
    private final int weekdaysDiscount;
    private final int weekendsDiscount;
    private final int specialDiscount;
    private final boolean freeChampagne;
    private final int xmasDdayDiscount;

    OrderResponse(
            List<Order> orderList,
            LocalDate orderDate,
            int weekdaysDiscount,
            int weekendsDiscount,
            int specialDiscount,
            boolean freeChampagne,
            int xmasDdayDiscount
    ) {
        this.orderList = orderList;
        this.orderDate = orderDate;
        this.weekdaysDiscount = weekdaysDiscount;
        this.weekendsDiscount = weekendsDiscount;
        this.specialDiscount = specialDiscount;
        this.freeChampagne = freeChampagne;
        this.xmasDdayDiscount = xmasDdayDiscount;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
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
