package TicTacToeGame;

public class PlayerFactory {

    public PlayerFactory() {
    }

    public Player buildPlayer(PlayerType player) {
        switch (player) {
            case HUMAN:
                return new HumanPlayer();
            case CLEVER:
                return new CleverPlayer();
            default:
                return new WhateverPlayer();
        }
    }
}
