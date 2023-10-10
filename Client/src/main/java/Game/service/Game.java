package Game.service;


import Game.model.GameField;

public class Game {

    private final Move opponnentMove;
    private final DataPrinter dataPrinter;
    private final Move userMove;
    private final WinnerVerifier winnerVerifier;
    private final CellVerifier cellVerifier;
    private final FirstStep firstStep;

    public Game(Move computerMove,
                DataPrinter dataPrinter,
                Move userMove,
                WinnerVerifier winnerVerifier,
                CellVerifier cellVerifier,
                FirstStep firstStep) {

        System.out.println("Game class init start");
        this.opponnentMove = computerMove;
        this.dataPrinter = dataPrinter;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
        this.firstStep = firstStep;
    }

    public void start() {

        System.out.println("Используйте следущие клавиши для игры 1-9:");

        dataPrinter.printMappingTable();

        final GameField gameField = new GameField();

        System.out.println("46");
        if (firstStep.isFirstStep()) {
            System.out.println("48");
            opponnentMove.make(gameField);
            System.out.println("50");
            dataPrinter.printGameTable(gameField);
        }
        System.out.println("51");

        while (true) {

            System.out.println("53");
            userMove.make(gameField);
            System.out.println("55");
            dataPrinter.printGameTable(gameField);
            if (winnerVerifier.isUserWin(gameField)) {
                System.out.println("You WiN");
                break;
            }
            if (cellVerifier.isAllCellFilled(gameField)) {
                System.out.println("DRAW");
                break;
            }

            //
            opponnentMove.make(gameField);
            dataPrinter.printGameTable(gameField);
            if (winnerVerifier.isComputerWin(gameField)) {
                System.out.println("Computer WiN");
                break;
            }
            if (cellVerifier.isAllCellFilled(gameField)) {
                System.out.println("DRAW");
                break;
            }
        }
        System.out.println("Game Over");
    }
}