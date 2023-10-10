package Game.model;

import java.util.Arrays;

public class GameField {
    private final char[][] field = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public boolean isEmpty(final Cell cell) {
        return field[cell.getRow()][cell.getCol()] == ' ';
    }

    public char getSign(final Cell cell) {
        return field[cell.getRow()][cell.getCol()];
    }

    public void setSign(final Cell cell, final char sign) {
        field[cell.getRow()][cell.getCol()] = sign;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameField{");
        sb.append("field=");
        for (int i = 0; i < field.length; i++) {
            sb.append(Arrays.toString(field[i]));
            if (i < field.length - 1)
                sb.append(" : ");
        }
        sb.append('}');
        return sb.toString();
    }
}
