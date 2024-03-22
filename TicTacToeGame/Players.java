package TicTacToeGame;

enum PlayerType {
    HUMAN,
    CLEVER,
    WHATEVER
}

interface Player {
    boolean playTurn(Board board, Mark mark);
}
