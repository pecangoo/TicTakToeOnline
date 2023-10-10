package Game.service;

import Game.model.Cell;
import Game.model.GameField;

public class CellVerifier {
    public boolean isAllCellFilled(GameField gameField) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameField.getSign(new Cell(i, j)) == ' ')
                    return false;
            }
        }
        return true;
    }
}
