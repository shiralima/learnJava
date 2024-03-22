package TicTacToeGame;

import java.util.Scanner;

public class HumanPlayer implements Player {

    public HumanPlayer() {
    }

    /*
     * This function get board and mark for play a turn
     * We first take numbers coordination from askCoordinationsFromUser function
     * If there are illegal the putMark function will return false, if so
     * we call askCoordinationsFromUser until the input will be legal
     */
    @Override
    public boolean playTurn(Board board, Mark mark) {
        boolean isTurnPlayed = false;
        boolean isGameFinished = false;
        while (!isTurnPlayed && !isGameFinished) {
            int[] coordination = askCoordinatesFromUser();
            int col = coordination[0];
            int row = coordination[1];
            isTurnPlayed = board.putMark(mark, row, col);
            if (isTurnPlayed) {
                if (board.isGameWin(mark, row, col) == null) {
                    isGameFinished = false;
                    return false;
                }
                isGameFinished = true;
                return true;
            }
            System.out.println("The coordination you give, is illegal");
        }
        return false;
    }

    private int[] askCoordinatesFromUser() {
        System.out
                .println("Please give legal coordinates to put your mark in. \n The first number will be the column:");
        Scanner in = new Scanner(System.in);
        int colNum, rowNum;

        while (true) {
            if (in.hasNextInt()) {
                colNum = in.nextInt() - 1;
                break;
            } else {
                System.out.println("Coordinates must be numbers. Please try again.");
                in.nextLine();
            }
        }

        System.out.println("The second number will be the row:");
        while (true) {
            if (in.hasNextInt()) {
                rowNum = in.nextInt() - 1;
                break;
            } else {
                System.out.println("Coordinates must be numbers. Please try again.");
                in.nextLine();
            }
        }

        int[] coordinates = { colNum, rowNum };
        return coordinates;
    }
}