package cli.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void getSize() {
        final Board board = new Board();

        assertEquals(3, board.getSize());
    }

    @Test
    public void setFigure() {
        final Board board = new Board();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        board.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = board.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);

    }
}