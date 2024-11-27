package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class UtecoRestaurantTest extends NsTest {

    @Test
    void 기대하는_12월_이벤트_플래너_예시_테스트() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output().replace("\r\n", "\n")).contains(
                    """
                    안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
                    12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)""",
                    """
                    주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)""",
                    """
                    12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
                    
                    <주문 메뉴>
                    티본스테이크 1개
                    바비큐립 1개
                    초코케이크 2개
                    제로콜라 1개
                    
                    <할인 전 총주문 금액>
                    142,000원
                    
                    <증정 메뉴>
                    샴페인 1개
                    
                    <혜택 내역>
                    크리스마스 디데이 할인: -1,200원
                    평일 할인: -4,046원
                    특별 할인: -1,000원
                    증정 이벤트: -25,000원
                    
                    <총혜택 금액>
                    -31,246원
                    
                    <할인 후 예상 결제 금액>
                    135,754원
                    
                    <12월 이벤트 배지>
                    산타"""
            );
        });
    }

    @Test
    void 적용된_이벤트가_하나도_없는_경우_테스트() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output().replace("\r\n", "\n")).contains(
                    """
                    안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
                    12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)""",
                    """
                    주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)""",
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

    @Test
    void 총주문_금액_10000원_이상부터_이벤트가_적용_테스트() {
        assertSimpleTest(() -> {
            run("3", "아이스크림-2");
            assertThat(output().replace("/r/n", "/n")).doesNotContain("<총혜택 금액>\n"
                    + "-6,246원");
        });
    }

    @Test
    void 고객이_메뉴판에_없는_메뉴를_입력하는_경우_테스트() {
        assertSimpleTest(() -> {
            run("3", "김치찌개-2", "타파스-1,제로콜라-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 메뉴의_개수_1_미만을_입력하는_경우_테스트() {
        assertSimpleTest(() -> {
            run("3", "시저샐러드-1,시저샐러드-1", "타파스-1,제로콜라-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 날짜_예외테스트() {
        assertSimpleTest(() -> {
            run("a", "31", "타파스-1,제로콜라-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외테스트() {
        assertSimpleTest(() -> {
            run( "31", "a-1,제로콜라-1", "타파스-1,제로콜라-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 최대_주문_예외테스트() {
        assertSimpleTest(() -> {
            run( "31", "타파스-10,제로콜라-11", "타파스-10,제로콜라-10");
            assertThat(output()).contains("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        });
    }

    @Test
    void 음료만_주문시_예외테스트() {
        assertSimpleTest(() -> {
            run( "31", "제로콜라-12", "타파스-10,제로콜라-10");
            assertThat(output()).contains("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
