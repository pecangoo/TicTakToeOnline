package Game.service;

import Game.model.Cell;
import Game.model.GameField;

public class DataPrinter {
    public void printMappingTable() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-------------\n");
        stringBuilder.append("| 7 | 8 | 9 |\n");
        stringBuilder.append("-------------\n");
        stringBuilder.append("| 4 | 5 | 6 |\n");
        stringBuilder.append("-------------\n");
        stringBuilder.append("| 1 | 2 | 3 |\n");
        stringBuilder.append("-------------\n");
        System.out.println(stringBuilder);
    }

    public void printGameTable(GameField gameField) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("=============\n");
        for (int i = 0; i < 3; i++) {
            stringBuilder.append("|");
            for (int j = 0; j < 3; j++) {
                stringBuilder.append(" ");
                stringBuilder.append(gameField.getSign(new Cell(2 - i, j)));
                stringBuilder.append(" |");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("=============\n\n");
        System.out.println(stringBuilder);
    }
}
