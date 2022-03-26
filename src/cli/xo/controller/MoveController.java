package cli.xo.controller;

import cli.xo.model.Board;
import cli.xo.model.Figure;
import cli.xo.model.Point;
import cli.xo.model.exceptions.AlreadyOccupiedException;
import cli.xo.model.exceptions.InvalidPointException;

public class MoveController {

    public void applyFigure(final Board board,
                            final Figure figure,
                            final Point point) throws AlreadyOccupiedException, InvalidPointException {

        if (board.getFigure(point) != null)
            throw new AlreadyOccupiedException();

        board.setFigure(point, figure);
    }



}
