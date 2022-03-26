package cli.xo.model;

import cli.xo.model.exceptions.AlreadyOccupiedException;
import cli.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testGetSize() {
        final Board board = new Board();

        assertEquals(3, board.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Board board = new Board();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        board.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = board.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Board board = new Board();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = board.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception {
        final Board board = new Board();
        final Point inputPoint = new Point(-1,0);

        try {
            board.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException ipe) {
        }
    }

    @Test
    public void testGetFigureWhenYIsLessThenZero() throws Exception {
        final Board board = new Board();
        final Point inputPoint = new Point(0,-1);

        try {
            board.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException ipe) {
        }
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception {
        final Board board = new Board();
        final Point inputPoint = new Point(board.getSize() + 1, 0);

        try {
            board.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException ipe) {
        }
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception {
        final Board board = new Board();
        final Point inputPoint = new Point(0, board.getSize() + 1);

        try {
            board.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException ipe) {
        }
    }


}
