package coordinate.domain.figure;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import coordinate.domain.Point;
import coordinate.exception.InvalidFigureException;

public enum FigureFactory {
	LINE(2, Line::new),
	TRIANGLE(3, Triangle::new),
	RECTANGLE(4, Rectangle::new);

	private final int size;
	private final Function<List<Point>, Figure> creator;

	FigureFactory(int size, Function<List<Point>, Figure> creator) {
		this.size = size;
		this.creator = creator;
	}

	public static Figure getFigure(List<Point> points) throws InvalidFigureException {
		int size = points.size();
		return Arrays.stream(values())
				.filter(figure -> figure.matchSize(size))
				.findFirst()
				.orElseThrow(InvalidFigureException::new)
				.create(points);
	}

	private boolean matchSize(int size) {
		return this.size == size;
	}

	private Figure create(List<Point> points) {
		return creator.apply(points);
	}
}