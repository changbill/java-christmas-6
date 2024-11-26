package christmas.model.discount;

import static christmas.constant.UtecoDiscountConstant.DAY_OF_THE_WEEK_DISCOUNT_UNIT_PER_MENU;
import static christmas.constant.UtecoDiscountConstant.STAR_DISCOUNT_AMOUNT;
import static christmas.constant.UtecoDiscountConstant.XMAS_D_DAY_DISCOUNT_UNIT;
import static christmas.constant.UtecoDiscountConstant.XMAS_D_DAY_START_DISCOUNT;
import static christmas.constant.UtecoMenu.*;
import static christmas.constant.UtecoMenu.T_BONE_STEAK;
import static org.junit.jupiter.api.Assertions.*;

import christmas.model.Order;
import christmas.model.Orders;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculateDiscountTest {

    private static LocalDate customDate(int date) {
        return LocalDate.of(2023, 12, date);
    }

    @Nested
    @DisplayName("날짜 테스트")
    class DateTest {

        @ParameterizedTest
        @ValueSource(ints = {1, 25})
        void 크리스마스와_새해_이벤트_테스트(int date) {
            Orders orders = getXmasAndNewYearOrders(date);
            CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

            assertTrue(calculateDiscount.getXmasDdayDiscount() != 0);
            assertTrue(
                    calculateDiscount.getWeekdaysDiscount() != 0 ||
                            calculateDiscount.getWeekendsDiscount() != 0
            );
        }

        @ParameterizedTest
        @ValueSource(ints = {26, 31})
        void 새해_이벤트_테스트(int date) {
            Orders orders = getXmasAndNewYearOrders(date);
            CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

            assertEquals(calculateDiscount.getXmasDdayDiscount(), 0);
            assertTrue(
                    calculateDiscount.getWeekdaysDiscount() != 0 ||
                            calculateDiscount.getWeekendsDiscount() != 0
            );
        }

        private static Orders getXmasAndNewYearOrders(int date) {
            return Orders.of(List.of(
                    Order.of(T_BONE_STEAK.getMenuName(), 2),
                    Order.of(ICE_CREAM.getMenuName(), 2)
            ), customDate(date));
        }
    }

    @Nested
    @DisplayName("평일 할인 테스트")
    class WeekdaysDiscountTest {
        private static final int WEEKDAY_DATE = 25;

        @ParameterizedTest
        @ValueSource(ints = {2, 20})
        void 평일_할인_테스트1(int quantity) {
            Orders orders = Orders.of(
                    List.of(Order.of(ICE_CREAM.getMenuName(), quantity)),
                    customDate(WEEKDAY_DATE)
            );
            CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

            assertEquals(calculateDiscount.getWeekdaysDiscount(), quantity * DAY_OF_THE_WEEK_DISCOUNT_UNIT_PER_MENU);
        }

        @ParameterizedTest
        @ValueSource(ints = {2, 10})
        void 평일_할인_테스트2(int quantity) {
            Orders orders = Orders.of(
                    List.of(
                            Order.of(ICE_CREAM.getMenuName(), quantity),
                            Order.of(CHOCOLATE_CAKE.getMenuName(), quantity)
                    ),
                    customDate(WEEKDAY_DATE)
            );
            CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

            assertEquals(calculateDiscount.getWeekdaysDiscount(),
                    quantity * 2 * DAY_OF_THE_WEEK_DISCOUNT_UNIT_PER_MENU);
        }
    }

    @Nested
    @DisplayName("주말 할인 테스트")
    class WeekendsDiscountTest {
        private static final int WEEKEND_DATE = 1;

        @ParameterizedTest
        @ValueSource(ints = {2, 20})
        void 주말_할인_테스트1(int quantity) {
            Orders orders = Orders.of(
                    List.of(Order.of(T_BONE_STEAK.getMenuName(), quantity)),
                    customDate(WEEKEND_DATE)
            );
            CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

            assertEquals(calculateDiscount.getWeekendsDiscount(), quantity * DAY_OF_THE_WEEK_DISCOUNT_UNIT_PER_MENU);
        }

        @ParameterizedTest
        @ValueSource(ints = {2, 10})
        void 주말_할인_테스트2(int quantity) {
            Orders orders = Orders.of(
                    List.of(
                            Order.of(T_BONE_STEAK.getMenuName(), quantity),
                            Order.of(BARBECUE_RIBS.getMenuName(), quantity)
                    ),
                    customDate(WEEKEND_DATE)
            );
            CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

            assertEquals(calculateDiscount.getWeekendsDiscount(),
                    quantity * 2 * DAY_OF_THE_WEEK_DISCOUNT_UNIT_PER_MENU);
        }
    }

    @Nested
    @DisplayName("특별 할인 테스트")
    class SpecialDiscountTest {

        @ParameterizedTest
        @ValueSource(ints = {3, 10, 17, 24, 25, 31})
        void 특별_할인_날짜_테스트(int dateNumber) {
            Orders orders = Orders.of(
                    List.of(Order.of(T_BONE_STEAK.getMenuName(), 1)),
                    customDate(dateNumber)
            );
            CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

            assertEquals(calculateDiscount.getSpecialDiscount(), STAR_DISCOUNT_AMOUNT);
        }

        @ParameterizedTest
        @ValueSource(ints = {4, 16, 20, 26, 28, 30})
        void 특별_할인_날짜_아님_테스트(int dateNumber) {
            Orders orders = Orders.of(
                    List.of(Order.of(T_BONE_STEAK.getMenuName(), 1)),
                    customDate(dateNumber)
            );
            CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

            assertEquals(calculateDiscount.getSpecialDiscount(), 0);
        }
    }

    @Nested
    @DisplayName("증정 이벤트 테스트")
    class PresentChampagneTest {

        @ParameterizedTest
        @ValueSource(ints = {8, 20})
        void 샴페인_증정_테스트(int quantity) {

            Orders orders = Orders.of(
                    List.of(Order.of(CHOCOLATE_CAKE.getMenuName(), quantity)),
                    customDate(25)
            );
            CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

            assertTrue(calculateDiscount.isFreeChampagne());
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 7})
        void 샴페인_미증정_테스트(int quantity) {

            Orders orders = Orders.of(
                    List.of(Order.of(CHOCOLATE_CAKE.getMenuName(), quantity)),
                    customDate(25)
            );
            CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

            assertFalse(calculateDiscount.isFreeChampagne());
        }
    }

    @Nested
    @DisplayName("크리스마스 디데이 할인 테스트")
    class XmasDdayDiscountTest {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 6, 24, 25})
        void 크리스마스_디데이_할인_테스트(int dateNumber) {
            Orders orders = Orders.of(
                    List.of(Order.of(T_BONE_STEAK.getMenuName(), 1)),
                    customDate(dateNumber)
            );
            CalculateDiscount calculateDiscount = CalculateDiscount.of(orders);

            assertEquals(calculateDiscount.getXmasDdayDiscount(), XMAS_D_DAY_START_DISCOUNT + XMAS_D_DAY_DISCOUNT_UNIT * (dateNumber - 1));
        }
    }
}