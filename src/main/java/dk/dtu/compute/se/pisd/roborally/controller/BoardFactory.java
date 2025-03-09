package dk.dtu.compute.se.pisd.roborally.controller;

import dk.dtu.compute.se.pisd.roborally.model.Board;
import dk.dtu.compute.se.pisd.roborally.model.Heading;
import dk.dtu.compute.se.pisd.roborally.model.Space;

import java.util.Arrays;
import java.util.List;

/**
 * A factory for creating boards. The factory itself is implemented as a singleton.
 *
 * @author Ekkart Kindler, ekki@dtu.dk
 */
// XXX A3: might be used for creating a first slightly more interesting board.
public class BoardFactory {

    /**
     * The single instance of this class, which is lazily instantiated on demand.
     */
    static private BoardFactory instance = null;

    /**
     * Constructor for BoardFactory. It is private in order to make the factory a singleton.
     */
    private BoardFactory() {
    }

    /**
     * Returns the single instance of this factory. The instance is lazily
     * instantiated when requested for the first time.
     *
     * @return the single instance of the BoardFactory
     */
    public static BoardFactory getInstance() {
        if (instance == null) {
            instance = new BoardFactory();
        }
        return instance;
    }


    public List<String> getAvailableBoardNames() {
        return Arrays.asList("Classic", "Maze", "Race Track"); // Added predefined board names
    }

    /**
     * Creates a board based on the given name.
     * Different board layouts can be implemented here.
     *
     * @param name The name of the board
     * @return A new Board instance
     */
    public Board createBoard(String name) {

        Board board;
        if (name == null) {
            board = new Board(8,8, "<none>");
        } else {
            board = new Board(8, 8, name);

            // Added switch case to create specific board layouts
            switch (name) {
                case "Classic":
                    createClassicBoard(board);
                    break;
                case "Maze":
                    createMazeBoard(board);
                    break;
                case "Race Track":
                    createRaceTrackBoard(board);
                    break;
                default:
                    break;
            }
        }

        return board;
    }

    /**
     * Creates a simple board with some conveyor belts and walls.
     */
    private void createClassicBoard(Board board) {
        Space space = board.getSpace(0, 0);
        space.getWalls().add(Heading.SOUTH);
        ConveyorBelt action = new ConveyorBelt();
        action.setHeading(Heading.WEST);
        space.getActions().add(action);
    }

    /**
     * Creates a maze-like board by adding walls to form a barrier.
     */
    private void createMazeBoard(Board board) {
        for (int i = 0; i < 8; i++) {
            board.getSpace(i, 4).getWalls().add(Heading.SOUTH); // Creating a horizontal wall
        }
    }

    /**
     * Creates a racetrack with walls guiding the players.
     */
    private void createRaceTrackBoard(Board board) {
        for (int i = 0; i < 8; i++) {
            board.getSpace(i, 2).getWalls().add(Heading.EAST);
            board.getSpace(i, 6).getWalls().add(Heading.WEST);
        }
    }

}
