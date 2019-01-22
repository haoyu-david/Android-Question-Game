package com.example.haoyup.portandstarboard;

import java.util.Arrays;
import java.util.Collections;

/**
 * Immutable game class which randomly picks a side of the ship (port or starboard)
 * for the user to respond with an answer.
 *
 * Supports getting the name of the chosen side, and checking if an answer is correct.
 */

public class Game {
    public enum Side {
        PORT("Port"),
        STARBOARD("Starboard");

        private String name;

        private Side(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    ;


    private Side winner = Side.PORT;

    public Game() {
        // Pick a winner:
        Side buttons[] = {Side.PORT, Side.STARBOARD};
        Collections.shuffle(Arrays.asList(buttons));
        winner = buttons[0];
    }

    public String getChosenSideName() {
        return winner.getName();
    }

    public boolean checkIfCorrect(Side side) {
        return (winner == side);
    }
}


