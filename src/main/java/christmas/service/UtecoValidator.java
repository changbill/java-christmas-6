package christmas.service;

import static christmas.constant.UtecoRegex.ORDER_REGEX;
import static christmas.constant.menu.UtecoMenuType.BEVERAGE;

import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;
import christmas.exception.MenuMaximumExceedException;
import christmas.exception.OnlyBeverageException;
import christmas.model.Order;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtecoValidator {

    static void validateDate(int date) {
        if(date < 1 || date > 31) {
            throw new InvalidDateException();
        }
    }

    static void matchOrderValue(List<String> splitByComma) {
        Pattern pattern = Pattern.compile(ORDER_REGEX);

        for(String orderString : splitByComma) {
            Matcher matcher = pattern.matcher(orderString);
            if(!matcher.matches()) {
                System.out.println(new InvalidOrderException().getMessage());
                throw new InvalidOrderException();
            }
        }
    }

    static void validateOrdersException(List<Order> orders) {
        if(orders.stream().mapToInt(Order::getOrderQuantity).sum() > 20) {
            throw new MenuMaximumExceedException();
        }

        if(orders.stream().map(Order::getMenuType).allMatch(utecoMenuType -> utecoMenuType == BEVERAGE)) {
            throw new OnlyBeverageException();
        }
    }
}
