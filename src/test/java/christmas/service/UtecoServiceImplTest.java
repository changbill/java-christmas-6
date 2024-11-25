package christmas.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.exception.ExceptionMessage.ERROR_HEADER;
import static christmas.exception.ExceptionMessage.INVALID_DATE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.repository.UtecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UtecoServiceImplTest {

    UtecoServiceImpl utecoService;

    @BeforeEach
    void setUp() {
        utecoService = new UtecoServiceImpl(new UtecoRepository());
    }

    @ParameterizedTest
    @ValueSource(strings = {"qwer", "!", ":", "0", "32"})
    void 날짜_예외테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> utecoService.setDateToVisit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEADER)
                .hasMessageContaining(INVALID_DATE)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "31", "3", "4", "5"})
    void 날짜_테스트(String input) {
        assertSimpleTest(() ->
                assertDoesNotThrow(() -> utecoService.setDateToVisit(input))
        );
    }
}