package Game.service;

import Game.model.Cell;
import Game.model.GameField;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMove implements Move {


    public void make(GameField gameField) {
        System.out.println("Player step");
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please type number between 1 and 9:\n");
            try {
                Integer in = scanner.nextInt();
                if (!(in >= 1 && in <= 9)) continue;
                final int row = (in - 1) / 3;
                int col = (in - 1) % 3;
                System.out.println(row + " " + col);
                final Cell randomCell = new Cell(row, col);
                if (gameField.isEmpty(randomCell)) {
                    gameField.setSign(randomCell, 'X');
                    return;
                } else {
                    System.out.println("Can't make a move," +
                            " because the cell is not free! Try again!");
                    continue;
                }
            } catch (InputMismatchException ex) {
                scanner.nextLine();
            }
        }

    }
}
