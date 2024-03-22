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
        System.out.println("WE START THE GAME, GOOD LACK \n");
        System.out.println(String.format("X player is: %s", getPlayerTypeStr(playerX)));
        System.out.println(String.format("O player is: %s \n", getPlayerTypeStr(playerO)));
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

    private String getPlayerTypeStr(Player player) {
        if (player instanceof HumanPlayer) {
            return "Human Player";
        }
        if (player instanceof CleverPlayer) {
            return "Clever Player";
        }
        return "Whatever Player";
    }

    public Mark getWinner() {
        Mark[] players = { Mark.X, Mark.O };

        for (Mark player : players) {
            for (int i = 0; i < Board.SIZE; i++) {
                if (board.isGameWin(player, i, i) == Mark.BLANK) {
                    System.out.println("No one win :(");
                    return player;
                } else if (board.isGameWin(player, i, i) != null) {
                    System.out.println(player + " WINNNNN ");
                    return player;
                }
            }
        }
        return null;
    }

}
