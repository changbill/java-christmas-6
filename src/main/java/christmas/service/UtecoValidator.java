package christmas.service;

import static christmas.constant.UtecoRegex.ORDER_REGEX;

import christmas.exception.InvalidDateException;
import christmas.exception.InvalidOrderException;
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
                throw new InvalidOrderException();
            }
        }
    }
}
