package TicTacToeGame;

public class Game {

    private Board board;
    private Player playerX;
    private Player playerO;
    private Renderer renderer;

    public Game(Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
    }

    public void start() {
        System.out.println("WE START THE GAME, GOODLACK");
        this.board = new Board();
        this.renderer.renderBoard(this.board);
    }

    public static void main(String[] args) {
        Board board = new Board();
        Renderer renderer = new Renderer();
        Player player = new Player();
        renderer.renderBoard(board);

        player.playTurn(board, Mark.O, 0, 0);
        renderer.renderBoard(board);

        player.playTurn(board, Mark.O, 1, 2);
        renderer.renderBoard(board);

        player.playTurn(board, Mark.O, 2, 2);
        renderer.renderBoard(board);

    }
}
