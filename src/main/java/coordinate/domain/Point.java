package coordinate.domain;

import java.util.Objects;

public class Point {
	private final Position x;
	private final Position y;

	private Point(int x, int y) {
		this.x = Position.of(x);
		this.y = Position.of(y);
	}

	public double getDistance(Point other) {
		int xDifference = other.minusX(x.getValue());
		int yDifference = other.minusY(y.getValue());
		return Math.sqrt(square(xDifference) + square(yDifference));
	}

	private int minusX(int number) {
		return x.minus(number);
	}

	private int minusY(int number) {
		return y.minus(number);
	}

	private static int square(int number) {
		return number * number;
	}

	public static Point of(int x, int y) {
		return new Point(x, y);
	}

	public static Point ofCommaSeparator(String text) {
		String[] values = text.split(",");
		System.out.println(text);
		return new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point point = (Point)o;
		return x == point.x && y == point.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
