package coordinate.exception;

public class InvalidPositionException extends RuntimeException {
	public InvalidPositionException() {
		super("0 이상 24 이하의 값만 올 수 있습니다.");
	}
}
