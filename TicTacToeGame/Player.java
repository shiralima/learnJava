package TicTacToeGame;

public class Player {

    public Player() {
    }

    public boolean playTurn(Board board, Mark mark, int row, int col) {
        boolean isTurnPlayed = board.putMark(mark, row, col);
        if (!isTurnPlayed) {
            System.out.println("The coordination you give, is illegal. Please do your turn again");
            return false;
        }
        board.isGameOver();
        return true;
    }
}
