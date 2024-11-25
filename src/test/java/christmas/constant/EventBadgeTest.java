package christmas.constant;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.constant.EventBadge.NONE;
import static christmas.constant.EventBadge.SANTA;
import static christmas.constant.EventBadge.STAR;
import static christmas.constant.EventBadge.TREE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EventBadgeTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 4_999})
    void 이벤트_배지_없음_테스트(int benefitAmount) {
        assertSimpleTest(
                () -> assertThat(EventBadge.decideEventBadge(benefitAmount)).isEqualTo(NONE.getBadgeName())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {5_000, 9_999})
    void 이벤트_배지_별_테스트(int benefitAmount) {
        assertSimpleTest(
                () -> assertThat(EventBadge.decideEventBadge(benefitAmount)).isEqualTo(STAR.getBadgeName())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {10_000, 19_999})
    void 이벤트_배지_트리_테스트(int benefitAmount) {
        assertSimpleTest(
                () -> assertThat(EventBadge.decideEventBadge(benefitAmount)).isEqualTo(TREE.getBadgeName())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {20_000, 100_000})
    void 이벤트_배지_산타_테스트(int benefitAmount) {
        assertSimpleTest(
                () -> assertThat(EventBadge.decideEventBadge(benefitAmount)).isEqualTo(SANTA.getBadgeName())
        );
    }
}