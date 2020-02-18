package coordinate;

import java.util.List;

import coordinate.domain.Point;
import coordinate.domain.figure.FigureFactory;
import coordinate.exception.InvalidFigureException;
import coordinate.utils.PointParser;
import coordinate.view.InputView;

public class CoordinateApplication {
	public static void main(String[] args) {
		String value = InputView.getPoint();
		List<Point> points = PointParser.parse(value);
		try {
            FigureFactory.getFigure(points);
        } catch (InvalidFigureException e) {
            System.out.println(e.getMessage());
        }
	}
}
