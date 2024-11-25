package christmas.model.discount;

import christmas.constant.UtecoDiscountDate;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class NewYearEvent {
    private static final int discountUnitPerMenu = 2_023;
    private static final int starDiscountAmount = 1_000;

    private int weekdaysDiscount = 0;
    private int weekendsDiscount = 0;
    private int specialDiscount = 0;
    private boolean freeChampagne = false;

    public NewYearEvent(LocalDate targetDate, int totalOrderAmount) {
        UtecoDiscountDate.isNewYear(targetDate);
        dayOfWeekDiscount(targetDate);
        isDayOfStar(targetDate);
        isPresentChampagne(totalOrderAmount);
    }

    private void dayOfWeekDiscount(LocalDate targetDate) {
        if(isWeekend(targetDate)) {
            // TODO: UtecoMenuType.MAIN 가 몇개 있는지 찾는 로직 Order 도메인에 추가
            // TODO: weekendsDiscount = 해당 갯수 * discountUnitPerMenu;
            return;
        }
        // TODO: UtecoMenuType.DESERT 인지 찾는 로직 Order 도메인에 추가
        // TODO: weekdaysDiscount = 해당 갯수 * discountUnitPerMenu;
    }

    private void isDayOfStar(LocalDate targetDate) {
        DayOfWeek dayOfWeek = targetDate.getDayOfWeek();
        if(dayOfWeek.equals(DayOfWeek.SUNDAY) || targetDate.isEqual(LocalDate.of(2023, 12, 25))) {
            specialDiscount = starDiscountAmount;
        }
    }

    private void isPresentChampagne(int totalOrderAmount) {
        if(totalOrderAmount >= 120_000) {
            freeChampagne = true;
        }
    }

    private boolean isWeekend(LocalDate targetDate) {
        DayOfWeek dayOfWeek = targetDate.getDayOfWeek();
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }
}
