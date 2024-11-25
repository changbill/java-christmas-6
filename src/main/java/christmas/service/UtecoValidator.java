package christmas.service;

import christmas.exception.InvalidDateException;

public class UtecoValidator {

    static void validateDate(int date) {
        if(date < 1 || date > 31) {
            throw new InvalidDateException();
        }
    }
}
