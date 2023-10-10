package Game.service;

import Game.model.Cell;
import Game.model.GameField;

public class WinnerVerifier {
    public boolean isUserWin(GameField gameField) {
        return checkingField(gameField, 'X');
    }

    public boolean isComputerWin(GameField gameField) {
        return checkingField(gameField, '0');
    }

    private boolean checkingField(GameField gameField, Character sign) {
        Integer counterRows = 0, counterCols = 0, counterD1 = 0, counterD2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameField.getSign(new Cell(i, j)) == sign) counterCols++;
                if (gameField.getSign(new Cell(j, i)) == sign) counterRows++;
            }
            if (counterCols == 3 || counterRows == 3) return true;
            counterCols = 0;
            counterRows = 0;
        }

        for (int i = 0; i < 3; i++) {
            if (gameField.getSign(new Cell(i, i)) == sign) counterD1++;
            if (gameField.getSign(new Cell(2 - i, 2 - i)) == sign) counterD2++;
        }
        return counterD1 == 3 || counterD2 == 3;
    }
}
