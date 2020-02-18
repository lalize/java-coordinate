package coordinate.domain;

import java.util.HashMap;
import java.util.Map;

import coordinate.exception.InvalidPositionException;

public class Position {
	private static final int MIN = 0;
	private static final int MAX = 24;
	private static final Map<Integer, Position> cache = new HashMap<>();

	static {
		for (int position = MIN; position <= MAX; ++position) {
			cache.put(position, new Position(position));
		}
	}

	private final int position;

	private Position(int position) {
		validate(position);
		this.position = position;
	}

	public static Position of(int position) {
		validate(position);
		return cache.get(position);
	}

	private static void validate(int position) {
		if (position < MIN || position > MAX) {
			throw new InvalidPositionException();
		}
	}

	public int minus(int position) {
		return this.position - position;
	}

	public int getValue() {
		return position;
	}
}
