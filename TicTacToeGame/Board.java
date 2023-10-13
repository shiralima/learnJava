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

    // * Contractor: set game status to in progress and put all board as blank */
    public Board() {
        this.gameStatus = gameStatus.IN_PROGRESS;
        this.board = new Mark[SIZE][SIZE];

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
        isGameOver();
        return true;
    }

    public boolean isGameOver() {
        Mark playerWin;

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {

            }
        }

        this.gameStatus = GameStatus.IN_PROGRESS;
        return false;
        // System.out.println("YOU WIN:");
        // return true;
    }

    public Mark getMark(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return null;
        }
        return this.board[row][col];
    }

}
