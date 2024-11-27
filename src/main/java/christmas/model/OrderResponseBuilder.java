package christmas.model;

import java.time.LocalDate;
import java.util.List;

public class OrderResponseBuilder {
    private List<Order> orderList;
    private LocalDate orderDate;
    private int weekdaysDiscount;
    private int weekendsDiscount;
    private int specialDiscount;
    private boolean freeChampagne;
    private int xmasDdayDiscount;

    public OrderResponseBuilder orderList(List<Order> orderList) {
        this.orderList = orderList;
        return this;
    }

    public OrderResponseBuilder orderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public OrderResponseBuilder weekdaysDiscount(int weekdaysDiscount) {
        this.weekdaysDiscount = weekdaysDiscount;
        return this;
    }

    public OrderResponseBuilder weekendsDiscount(int weekendsDiscount) {
        this.weekendsDiscount = weekendsDiscount;
        return this;
    }

    public OrderResponseBuilder specialDiscount(int specialDiscount) {
        this.specialDiscount = specialDiscount;
        return this;
    }

    public OrderResponseBuilder freeChampagne(boolean freeChampagne) {
        this.freeChampagne = freeChampagne;
        return this;
    }

    public OrderResponseBuilder xmasDdayDiscount(int xmasDdayDiscount) {
        this.xmasDdayDiscount = xmasDdayDiscount;
        return this;
    }

    public OrderResponse build() {
        if(orderList == null || orderList.isEmpty() || orderDate == null) {
            throw new IllegalArgumentException("OrderResponseBuilder 만드는 도중 null 에러");
        }

        return new OrderResponse(
                orderList,
                orderDate,
                weekdaysDiscount,
                weekendsDiscount,
                specialDiscount,
                freeChampagne,
                xmasDdayDiscount
        );
    }
}
