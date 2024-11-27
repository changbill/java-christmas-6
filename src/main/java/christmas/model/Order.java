package christmas.model;

import christmas.constant.menu.UtecoMenu;
import christmas.constant.menu.UtecoMenuType;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return getMenu() == order.getMenu();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMenu(), getOrderQuantity());
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
