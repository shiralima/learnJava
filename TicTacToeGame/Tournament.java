package TicTacToeGame;

import java.util.Scanner;

public class Tournament {

    private Scanner scanner;
    private int tournamentNum; // ?
    private Mark[] wins;

    // * This info want change from game to game */
    private Player[] players;
    private Renderer renderer;

    /**
     * This function prompt all the message to the console.
     * Get the write values and call to build platers with them
     */

    public Tournament() {
        this.scanner = new Scanner(System.in);
    }

    public void startTournament() {
        System.out.println("Please enter round number for plying");
        tournamentNum = scanner.nextInt();

        System.out.println("Please enter if you want your board game render?");
        RendererType renderType = getValidRendererType();
        if (renderType.equals(RendererType.CONSOLE)) {
            renderer = new ConsoleRenderer();
        } else {
            renderer = new VoidRenderer();
        }

        System.out.println("Please enter the first player type");
        PlayerType player1Type = getValidPlayerType();

        System.out.println("Please enter the second player type");
        PlayerType player2Type = getValidPlayerType();

        PlayerType[] playerTypes = { player1Type, player2Type };
        buildPlayers(playerTypes);
    }

    /**
     * This function check that the input of the user is match to RendererType.
     * If not ask again until valid type given
     * 
     * @return valid RendererType
     */
    private RendererType getValidRendererType() {
        RendererType renderType = null;
        while (renderType == null) {
            String input = scanner.next().toUpperCase();
            try {
                renderType = RendererType.valueOf(input);
            } catch (IllegalArgumentException err) {
                System.err.println("Invalid player type: " + input);
                System.out.println("Valid player types:");
                for (RendererType type : RendererType.values()) {
                    System.out.print(String.format("%s ", type.name()));
                }
                System.out.println("\nPlease enter the player type again:");
            }
        }
        return renderType;
    }

    /**
     * This function check that the input of the user is match to PlayerType.
     * If not ask again until valid type given
     * 
     * @return valid PlayerType
     */
    private PlayerType getValidPlayerType() {
        PlayerType playerType = null;
        while (playerType == null) {
            String input = scanner.next().toUpperCase();
            try {
                playerType = PlayerType.valueOf(input);
            } catch (IllegalArgumentException err) {
                System.err.println("Invalid player type: " + input);
                System.out.println("Valid player types:");
                for (PlayerType type : PlayerType.values()) {
                    System.out.print(String.format("%s ", type.name()));
                }
                System.out.println("\nPlease enter the player type again:");
            }
        }
        return playerType;
    }

    /**
     * This function build the players to tournament.
     * After building call to startNewGameWith the players.
     * 
     * @param plyersTypes an array of all the player types to tournament given by
     *                    the user (startTournament function)
     */
    private void buildPlayers(PlayerType[] playersTypes) {
        players = new Player[2];
        for (int i = 0; i < 2; i++) {
            PlayerType playerType = playersTypes[i];
            switch (playerType) {
                case HUMAN:
                    players[i] = new HumanPlayer();
                    break;
                case CLEVER:
                    break;
                case WHATEVER:
                    break;
            }
        }
        this.players = players;
        startNewGame();
    }

    private void startNewGame() {
        Player currentPlayer = players[0];
        Player nextPlayer = players[1];
        int round = 1;

        while (round <= tournamentNum) {
            Game newGame = new Game(currentPlayer, nextPlayer, renderer);
            newGame.run();

            Player temp = currentPlayer;
            currentPlayer = nextPlayer;
            nextPlayer = temp;
            round++;
        }

    }

    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        tournament.startTournament();
    }
}
