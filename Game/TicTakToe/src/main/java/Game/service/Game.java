package Game.service;


import Game.model.GameField;

import java.util.Random;

public class Game {

    private final ComputerMove computerMove;
    private final DataPrinter dataPrinter;
    private final UserMove userMove;
    private final WinnerVerifier winnerVerifier;
    private final CellVerifier cellVerifier;

    public Game(ComputerMove computerMove,
                DataPrinter dataPrinter,
                UserMove userMove,
                WinnerVerifier winnerVerifier,
                CellVerifier cellVerifier) {
        this.computerMove = computerMove;
        this.dataPrinter = dataPrinter;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
    }


    public void start() {
        System.out.println("Используйте следущие клавиши для игры 1-9:");

        dataPrinter.printMappingTable();

        final GameField gameField = new GameField();

        if (new Random().nextBoolean()) {
            computerMove.make(gameField);
            dataPrinter.printGameTable(gameField);
        }

        while (true) {
            userMove.make(gameField);
            dataPrinter.printGameTable(gameField);
            if (winnerVerifier.isUserWin(gameField)) {
                System.out.println("You WiN");
                break;
            }
            if (cellVerifier.isAllCellFilled(gameField)) {
                System.out.println("DRAW");
                break;
            }
            computerMove.make(gameField);
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