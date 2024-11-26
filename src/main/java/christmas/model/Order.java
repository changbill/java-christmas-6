package christmas.model;

import christmas.constant.UtecoMenu;
import christmas.constant.UtecoMenuType;

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

    public UtecoMenu getMenu() {
        return menu;
    }

    public UtecoMenuType getMenuType() {
        return UtecoMenuType.getMenuType(menu);
    }

    public String getMenuName() {
        return menu.getMenuName();
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }
}
