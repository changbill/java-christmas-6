package christmas.model;

import christmas.model.discount.CalculateDiscount;
import java.time.LocalDate;
import java.util.List;

public class OrderResponse {
    private final List<Order> orderList;
    private final LocalDate orderDate;
    private int weekdaysDiscount;
    private int weekendsDiscount;
    private int specialDiscount;
    private boolean freeChampagne;
    private int xmasDdayDiscount;

    private OrderResponse(Orders orders) {
        orderList = orders.getOrderList();
        orderDate = orders.getOrderDate();

        CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);
        weekdaysDiscount = calculateDiscount.getWeekdaysDiscount();
        weekendsDiscount = calculateDiscount.getWeekendsDiscount();
        specialDiscount = calculateDiscount.getSpecialDiscount();
        freeChampagne = calculateDiscount.isFreeChampagne();
        xmasDdayDiscount = calculateDiscount.getXmasDdayDiscount();
    }

    public static OrderResponse from(Orders orders) {
        return new OrderResponse(orders);
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
