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
        this.board = new Board();
        this.renderer.renderBoard(this.board);
    }

    public void run() {
        System.out.println("WE START THE GAME, GOOD LACK");
        System.out.println(String.format("X player is: %s", playerX)); //TODO get type
        System.out.println(String.format("O player is: %s", playerO));
        int counter = 0;
        while (true) {
            if (counter % 2 == 0) {
                System.out.println("X turn now");
                if (this.playerX.playTurn(this.board, Mark.X)) {
                    this.renderer.renderBoard(this.board);
                    return;
                }
            } else {
                System.out.println("O turn now");
                if (this.playerO.playTurn(this.board, Mark.O)) {
                    this.renderer.renderBoard(this.board);
                    return;
                }
            }
            this.renderer.renderBoard(this.board);
            counter++;
        }
    }
}
