package coordinate.domain.figure;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import coordinate.domain.Point;
import coordinate.exception.InvalidFigureException;

public class FigureFactoryTest {
	@Test
	public void line() throws InvalidFigureException {
		List<Point> points = Arrays.asList(
				Point.of(1, 2),
				Point.of(2, 3));

		Figure figure = FigureFactory.getFigure(points);
		assertThat(figure).isInstanceOfAny(Line.class);
		assertThat(figure.getName()).isEqualTo("선");
	}

	@Test
	public void triangle() throws InvalidFigureException {
		List<Point> points = Arrays.asList(
				Point.of(1, 1),
				Point.of(4, 1),
				Point.of(1, 4));

		Figure figure = FigureFactory.getFigure(points);
		assertThat(figure).isInstanceOfAny(Triangle.class);
		assertThat(figure.getName()).isEqualTo("삼각형");
	}

	@Test
	public void rectangle() throws InvalidFigureException {
		List<Point> points = Arrays.asList(
				Point.of(1, 1),
				Point.of(4, 1),
				Point.of(1, 4),
				Point.of(4, 4));

		Figure figure = FigureFactory.getFigure(points);
		assertThat(figure).isInstanceOfAny(Rectangle.class);
		assertThat(figure.getName()).isEqualTo("사각형");
	}

	@Test
	public void invalid_figure() {
		List<Point> points = Arrays.asList(Point.of(1, 2));
		assertThatExceptionOfType(InvalidFigureException.class).isThrownBy(() -> {
			FigureFactory.getFigure(points);
		});
	}
}
