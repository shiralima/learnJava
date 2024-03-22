package TicTacToeGame;

enum Mark {
    BLANK, X, O
};

enum GameStatus {
    DRAW,
    X_WIN,
    O_WIN,
    IN_PROGRESS
}

public class Board {

    public static final int SIZE = 3;
    public static final int WIN_STREAK = 3;
    private Mark[][] board;
    private GameStatus gameStatus;
    private int fullCellsNum;

    // * Contractor: set game status to in progress and put all board as blank */
    public Board() {
        this.gameStatus = gameStatus.IN_PROGRESS;
        this.board = new Mark[SIZE][SIZE];
        this.fullCellsNum = 0;

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                this.board[row][col] = Mark.BLANK;
            }
        }
    }

    public boolean putMark(Mark mark, int row, int col) {
        // * If the row/col is'nt right, return false
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return false;
        }

        // * If the place already used, return false
        if (this.board[row][col] != Mark.BLANK) {
            return false;
        }

        this.board[row][col] = mark;
        this.fullCellsNum++;
        return true;
    }

    private boolean checkRow(Mark mark, int row) {
        int countStreak = 0;
        for (int col = 0; col < SIZE; col++) {
            if (this.board[row][col] == mark) {
                countStreak++;
                if (countStreak == WIN_STREAK) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkColumn(Mark mark, int col) {
        int countStreak = 0;
        for (int row = 0; row < SIZE; row++) {
            if (this.board[row][col] == mark) {
                countStreak++;
                if (countStreak == WIN_STREAK) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(Mark mark, int col, int row) {
        int countStreak = 1;
        int rowToCheck = row;
        int colToCheck = col;

        // Check bottom-right diagonal
        while (rowToCheck < SIZE - 1 && colToCheck < SIZE - 1 && this.board[rowToCheck + 1][colToCheck + 1] == mark) {
            rowToCheck++;
            colToCheck++;
            countStreak++;
            if (countStreak == WIN_STREAK) {
                return true;
            }
        }

        // Reset the counters
        rowToCheck = row;
        colToCheck = col;
        countStreak = 1;

        // Check top-left diagonal
        while (rowToCheck > 0 && colToCheck > 0 && this.board[rowToCheck - 1][colToCheck - 1] == mark) {
            rowToCheck--;
            colToCheck--;
            countStreak++;
            if (countStreak == WIN_STREAK) {
                return true;
            }
        }

        // Reset the counters
        rowToCheck = row;
        colToCheck = col;
        countStreak = 1;

        // Check bottom-left diagonal
        while (rowToCheck < SIZE - 1 && colToCheck > 0 && this.board[rowToCheck + 1][colToCheck - 1] == mark) {
            rowToCheck++;
            colToCheck--;
            countStreak++;
            if (countStreak == WIN_STREAK) {
                return true;
            }
        }

        // Reset the counters
        rowToCheck = row;
        colToCheck = col;
        countStreak = 1;

        // Check top-right diagonal
        while (rowToCheck > 0 && colToCheck < SIZE - 1 && this.board[rowToCheck - 1][colToCheck + 1] == mark) {
            rowToCheck--;
            colToCheck++;
            countStreak++;
            if (countStreak == WIN_STREAK) {
                return true;
            }
        }

        return false;
    }

    public Mark isGameWin(Mark markTurn, int rowTurn, int colTurn) {
        if (this.fullCellsNum == SIZE * SIZE) {
            return Mark.BLANK;
        }

        if (checkRow(markTurn, rowTurn) ||
                checkColumn(markTurn, colTurn) ||
                checkDiagonal(markTurn, colTurn, rowTurn)) {
            return markTurn;
        }
        return null;
    }

    public Mark getMark(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return null;
        }
        return this.board[row][col];
    }

}
