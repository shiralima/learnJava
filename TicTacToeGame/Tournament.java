package TicTacToeGame;

import java.util.Arrays;
import java.util.Scanner;

public class Tournament {

    private Scanner scanner;
    private int tournamentRoundNum; // ?
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

    public void playTournament() {
        System.out.println("Please enter round number for plying");
        tournamentRoundNum = scanner.nextInt();

        this.wins = new Mark[tournamentRoundNum];
        Arrays.fill(this.wins, Mark.BLANK);

        System.out.println("Please enter how you want your board game will be render?");
        RendererFactory rendererFactory = new RendererFactory();
        renderer = rendererFactory.buildRenderer(getValidRendererType());

        System.out.println("Please enter the first player type");
        PlayerType player1Type = getValidPlayerType();

        System.out.println("Please enter the second player type");
        PlayerType player2Type = getValidPlayerType();

        PlayerType[] playerTypes = { player1Type, player2Type };
        buildPlayers(playerTypes);

        startPlayGames();
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
     * After building call to startPlayGamesWith the players.
     * 
     * @param plyersTypes an array of all the player types to tournament given by
     *                    the user (playTournament function)
     */
    private void buildPlayers(PlayerType[] playersTypes) {
        PlayerFactory playerFactory = new PlayerFactory();
        players = new Player[2];
        for (int i = 0; i < 2; i++) {
            players[i] = playerFactory.buildPlayer(playersTypes[i]);
        }
        this.players = players;
    }

    public void showTournamentResult() {
        System.out.println("Tournament Results:");
        System.out.println("Round\t\tWinner");
        for (int i = 0; i < this.tournamentRoundNum; i++) {
            if (wins[i] == Mark.BLANK) {
                System.out.println((i + 1) + "\t\t" + "no one win");
            }
            System.out.println((i + 1) + "\t\t" + wins[i]);
        }
    }

    private void startPlayGames() {
        Player currentPlayer = players[0];
        Player nextPlayer = players[1];
        int roundPlayed = 0;

        while (roundPlayed < tournamentRoundNum) {
            Game newGame = new Game(currentPlayer, nextPlayer, renderer);
            newGame.run();
            
            wins[roundPlayed] = newGame.getWinner();
            Player temp = currentPlayer;
            currentPlayer = nextPlayer;
            nextPlayer = temp;
            roundPlayed++;
        }
        showTournamentResult();
    }

    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        tournament.playTournament();
    }
}
