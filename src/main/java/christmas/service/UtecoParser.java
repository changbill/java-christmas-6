package christmas.service;

import static christmas.constant.UtecoRegex.ORDER_REGEX;

import christmas.exception.InvalidDateException;
import christmas.model.Order;
import christmas.model.Orders;
import christmas.util.Validator;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtecoParser {

    static int parseToDate(String value) {
        Validator.validateInteger(value, new InvalidDateException());
        int date = Integer.parseInt(value);
        UtecoValidator.validateDate(date);
        return date;
    }

    static Orders parseToOrders(String orderValue, LocalDate date) {
        List<String> splitByComma =
                Arrays.stream(orderValue.split(",")).map(String::trim).toList();
        UtecoValidator.matchOrderValue(splitByComma);

        return Orders.of(matchMenuNameAndQuantity(splitByComma), date);
    }

    private static List<Order> matchMenuNameAndQuantity(List<String> splitByComma) {
        Pattern pattern = Pattern.compile(ORDER_REGEX);

        return splitByComma.stream()
                .map(orderString -> {
                    Matcher matcher = pattern.matcher(orderString);
                    String menuName = matcher.group(1);                         // 메뉴 이름
                    int orderQuantity = Integer.parseInt(matcher.group(2));     // 주문량
                    return Order.of(menuName, orderQuantity);
                })
                .toList();
    }
}
