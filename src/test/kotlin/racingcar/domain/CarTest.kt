package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "A", "james", "JAMES", "PoBi"])
    fun `자동차이름_대소문자길이1~5_정상`(name: String) {
        Car(name)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "course"])
    fun `자동차이름_길이5초과_에러`(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["우아한", "프리코스", "pobi.", "car,", "de-jo"])
    fun `자동차이름_대소문자X_에러`(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }
}