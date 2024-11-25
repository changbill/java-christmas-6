package christmas.service;

import christmas.exception.InvalidDateException;
import christmas.util.Validator;

public class UtecoParser {

    static int parseToDate(String value) {
        Validator.validateInteger(value, new InvalidDateException());
        int date = Integer.parseInt(value);
        UtecoValidator.validateDate(date);
        return date;
    }
}
