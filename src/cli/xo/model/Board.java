package cli.xo.model;

public class Board {

    private static final int FIELD_SIZE = 3;
    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) {
        return field[point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) {
        field[point.getX()][point.getY()] = figure;
    }

}
