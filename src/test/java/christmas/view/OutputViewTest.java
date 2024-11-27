package christmas.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.constant.menu.UtecoMenu.ICE_CREAM;
import static christmas.constant.menu.UtecoMenu.TAPAS;
import static christmas.constant.menu.UtecoMenu.T_BONE_STEAK;
import static christmas.constant.menu.UtecoMenu.ZERO_COKE;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.model.Order;
import christmas.model.OrderResponse;
import christmas.model.OrderResponseBuilder;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }

    @Nested
    @DisplayName("날짜, 평일 할인, 크리스마스 디데이 할인 출력 테스트")
    class DatePrintTest extends NsTest {

        @Test
        void 출력_테스트() {
            assertSimpleTest(() -> {
                run();
                assertThat(output().replace("\r\n", "\n")).contains(
                        """
                                12월 25일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
                                
                                <주문 메뉴>
                                아이스크림 2개
                                
                                <할인 전 총주문 금액>
                                10,000원
                                
                                <증정 메뉴>
                                없음
                                
                                <혜택 내역>
                                크리스마스 디데이 할인: -3,400원
                                평일 할인: -4,046원
                                특별 할인: -1,000원
                                
                                <총혜택 금액>
                                -8,446원
                                
                                <할인 후 예상 결제 금액>
                                1,554원
                                
                                <12월 이벤트 배지>
                                별"""
                );
            });
        }

        @Override
        protected void runMain() {
            OrderResponse orderResponse = new OrderResponseBuilder()
                    .orderList(List.of(Order.of(ICE_CREAM.getMenuName(), 2)))
                    .orderDate(customDate(25))
                    .xmasDdayDiscount(-3_400)
                    .weekdaysDiscount(-4_046)
                    .specialDiscount(-1_000)
                    .build();

            outputView.printOrderPreview(orderResponse);
        }
    }

    @Nested
    @DisplayName("주말 할인, 증정 이벤트, 이벤트 배지 출력 테스트")
    class EventPrintTest extends NsTest {

        @Test
        void 출력_테스트() {
            assertSimpleTest(() -> {
                run();
                assertThat(output().replace("\r\n", "\n")).contains(
                        """
                                12월 8일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
                                
                                <주문 메뉴>
                                티본스테이크 4개
                                
                                <할인 전 총주문 금액>
                                220,000원
                                
                                <증정 메뉴>
                                샴페인 1개
                                
                                <혜택 내역>
                                크리스마스 디데이 할인: -1,700원
                                주말 할인: -8,092원
                                증정 이벤트: -25,000원
                                
                                <총혜택 금액>
                                -34,792원
                                
                                <할인 후 예상 결제 금액>
                                210,208원
                                
                                <12월 이벤트 배지>
                                산타"""
                );
            });
        }

        @Override
        protected void runMain() {
            OrderResponse orderResponse = new OrderResponseBuilder()
                    .orderList(List.of(Order.of(T_BONE_STEAK.getMenuName(), 4)))
                    .orderDate(customDate(8))
                    .xmasDdayDiscount(-1_700)
                    .weekendsDiscount(-8_092)
                    .freeChampagne(true)
                    .build();

            outputView.printOrderPreview(orderResponse);
        }
    }

    @Nested
    @DisplayName("없음 출력 테스트")
    class NothingPrintTest extends NsTest {

        @Test
        void 출력_테스트() {
            assertSimpleTest(() -> {
                run();
                assertThat(output().replace("\r\n", "\n")).contains(
                        """
                                12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
                                
                                <주문 메뉴>
                                타파스 1개
                                제로콜라 1개
                                
                                <할인 전 총주문 금액>
                                8,500원
                                
                                <증정 메뉴>
                                없음
                                
                                <혜택 내역>
                                없음
                                
                                <총혜택 금액>
                                0원
                                
                                <할인 후 예상 결제 금액>
                                8,500원
                                
                                <12월 이벤트 배지>
                                없음"""
                );
            });
        }

        @Override
        protected void runMain() {
            OrderResponse orderResponse = new OrderResponseBuilder()
                    .orderList(List.of(
                            Order.of(TAPAS.getMenuName(), 1),
                            Order.of(ZERO_COKE.getMenuName(), 1)
                    ))
                    .orderDate(customDate(26))
                    .build();

            outputView.printOrderPreview(orderResponse);
        }
    }

    private LocalDate customDate(int dateNumber) {
        return LocalDate.of(2023, 12, dateNumber);
    }
}