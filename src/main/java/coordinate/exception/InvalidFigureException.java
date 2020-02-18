package coordinate.exception;

public class InvalidFigureException extends Exception {
	public InvalidFigureException() {
		super("유효하지 않은 도형입니다.");
	}
}
