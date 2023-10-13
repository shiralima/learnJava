package TicTacToeGame;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        Renderer renderer = new Renderer();
        renderer.renderBoard(board);
    }
}
