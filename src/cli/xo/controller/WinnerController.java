package cli.xo.controller;

import cli.xo.model.Board;
import cli.xo.model.Figure;
import cli.xo.model.Point;
import cli.xo.model.exceptions.InvalidPointException;

public class WinnerController {

    public Figure getWinner(final Board board) {
        try {
            for (int i = 0; i < board.getSize(); i++) {
                if (check(board, new Point(i, 0), new IPointChanger() {
                    @Override
                    public Point next(Point p) {
                        return new Point(p.getX(), p.getY() + 1);
                    }
                }))
                    return board.getFigure(new Point(i, 0));
            }

            for (int i = 0; i < board.getSize(); i++) {
                if (check(board, new Point(0, i), p -> new Point(p.getX() + 1, p.getY())))
                    return board.getFigure(new Point(0, i));
            }

            if (check(board, new Point(0, 0), new IPointChanger() {
                @Override
                public Point next(Point p) {
                    return new Point(p.getX() + 1, p.getY() + 1);
                }
            }))
                return board.getFigure(new Point(0, 0));

            if (check(board, new Point(0, board.getSize() - 1), p -> new Point(p.getX() + 1, p.getY() - 1)))
                return board.getFigure(new Point(0, 0));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean check(final Board board,
                          final Point startPoint,
                          final IPointChanger pointChanger) {

        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointChanger.next(startPoint);

        try {
            currentFigure = board.getFigure(startPoint);
            nextFigure = board.getFigure(nextPoint);
        } catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure == null)
            return false;
        if (currentFigure != nextFigure)
            return false;
        return check(board, nextPoint, pointChanger);
    }

    private interface IPointChanger {

        Point next(final Point p);

    }

}
