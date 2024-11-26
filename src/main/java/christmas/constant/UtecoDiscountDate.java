package christmas.constant;

import java.time.LocalDate;

public enum UtecoDiscountDate {
    XMAS_D_DAY_DISCOUNT(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25)),
    NEW_YEAR_DISCOUNT(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31)),
    ;

    private final LocalDate startDate;
    private final LocalDate endDate;

    UtecoDiscountDate(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public static boolean isXmasDday(LocalDate dateToVisit) {
        return XMAS_D_DAY_DISCOUNT.startDate.isBefore(dateToVisit) &&
                XMAS_D_DAY_DISCOUNT.endDate.isAfter(dateToVisit) ||
                XMAS_D_DAY_DISCOUNT.startDate.equals(dateToVisit) ||
                XMAS_D_DAY_DISCOUNT.endDate.equals(dateToVisit);
    }

    public static boolean isNewYear(LocalDate dateToVisit) {
        return NEW_YEAR_DISCOUNT.startDate.isBefore(dateToVisit) &&
                NEW_YEAR_DISCOUNT.endDate.isAfter(dateToVisit) ||
                NEW_YEAR_DISCOUNT.startDate.equals(dateToVisit) ||
                NEW_YEAR_DISCOUNT.endDate.equals(dateToVisit);
    }
}
