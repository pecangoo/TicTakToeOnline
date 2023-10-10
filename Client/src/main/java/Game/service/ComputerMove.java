package Game.service;

import Game.model.Cell;
import Game.model.GameField;

import java.util.Random;

public class ComputerMove {
    public void make(GameField gameField) {
        System.out.println("Computer step");
        final Random random = new Random();
        while (true) {
            final int row = random.nextInt(3);
            final int col = random.nextInt(3);
            final Cell randomCell = new Cell(row, col);
            if (gameField.isEmpty(randomCell)) {
                gameField.setSign(randomCell, '0');
                return;
            }
        }
    }
}
