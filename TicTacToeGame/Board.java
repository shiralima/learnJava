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
        if (row <= 0 || col <= 0) {
            return false;
        }
        // If col/row is already used -> return false

        // Put the mark in the right place:
        // Set the board with the new place
        // Render the board
        // Check if game over
        return true;
    }

    public boolean isGameOver() {
        this.gameStatus = GameStatus.IN_PROGRESS;
        return false;
    }

    public Mark getMark(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return null;
        }
        return this.board[row][col];
    }

}
