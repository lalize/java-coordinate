package coordinate.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	void constructor() {
		assertThat(Position.of(0)).isInstanceOf(Position.class);
	}

	@Test
	void of() {
		assertThat(Position.of(0)).isEqualTo(Position.of(0));
	}
}
