package coordinate.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import coordinate.exception.InvalidPositionException;

public class PointTest {
    @Test
    public void 생성() {
        Point a = Point.ofCommaSeparator("1,2");
        assertThat(a).isEqualTo(Point.of(1, 2));
    }

    @Test
    void 생성_잘못된_위치를_설정() {
        assertThatExceptionOfType(InvalidPositionException.class).isThrownBy(() -> Point.of(25, 0));
        assertThatExceptionOfType(InvalidPositionException.class).isThrownBy(() -> Point.of(0, 25));
        assertThatExceptionOfType(InvalidPositionException.class).isThrownBy(() -> Point.of(-1, 0));
        assertThatExceptionOfType(InvalidPositionException.class).isThrownBy(() -> Point.of(0, -1));


    }
}
