package christmas.model;

import christmas.constant.UtecoMenu;

public class Order {
    private final UtecoMenu menu;
    private final int orderQuantity;

    private Order(String menuName, int orderQuantity) {
        this.menu = UtecoMenu.ofMenuName(menuName);
        this.orderQuantity = orderQuantity;
    }

    public static Order of(String menuName, int orderQuantity) {
        return new Order(menuName, orderQuantity);
    }
}
