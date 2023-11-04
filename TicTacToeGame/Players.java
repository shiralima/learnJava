package TicTacToeGame;

enum PlayerType {
    HUMAN,
    CLEVER,
    WHATEVER
}

interface Player {
    public boolean playTurn(Board board, Mark mark);
}
