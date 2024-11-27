package christmas.model;

import christmas.constant.menu.UtecoMenuType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> orderList;
    private final LocalDate date;

    private Orders(List<Order> orderList, LocalDate date) {
        this.orderList = orderList;
        this.date = date;
    }

    public static Orders of(List<Order> orderList, LocalDate date) {
        return new Orders(orderList, date);
    }

    public List<Order> getOrderList() {
        return new ArrayList<>(orderList);
    }

    public int getTotalOrderAmount() {
        return orderList.stream()
                .mapToInt(order -> order.getMenu().getPrice() * order.getOrderQuantity())
                .sum();
    }

    public int getMenuTypeCount(UtecoMenuType menuType) {
        return orderList.stream()
                .filter(order -> order.getMenuType() == menuType)
                .mapToInt(Order::getOrderQuantity)
                .sum();
    }

    public LocalDate getOrderDate() {
        return date;
    }
}
