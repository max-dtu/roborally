package dk.dtu.compute.se.pisd.roborally.controller;

import dk.dtu.compute.se.pisd.roborally.model.Space;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a checkpoint on the board.
 * Players reaching a checkpoint can use it as a respawn point.
 */
public class Checkpoint extends FieldAction {

    private int number; // Identifies checkpoint order

    /**
     * Constructor for creating a checkpoint with a specific number.
     *
     * @param number Checkpoint number
     */
    public Checkpoint(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Triggers when a player reaches this checkpoint.
     * Updates the player's last reached checkpoint.
     *
     * @param gameController The game controller
     * @param space          The space where the checkpoint is located
     * @return true if the action was successful
     */
    @Override
    public boolean doAction(@NotNull GameController gameController, @NotNull Space space) {
        return true;
    }
}