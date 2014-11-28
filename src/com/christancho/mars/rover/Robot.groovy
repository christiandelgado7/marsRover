package com.christancho.mars.rover

/**
 * Class that represent the Rover in the Plateau
 *
 * @author Christian Delgado
 * @version 1.0
 * @date 11/23/14
 */
class Robot implements Serializable {

    /**
     * Coordinate X for the rover in the plateau
     */
    int xPos;
    /**
     * Coordinate Y for the rover in the plateau
     */
    int yPos;
    /**
     * Cardinal point where the Rover is looking
     */
    Look look;

    /**
     *
     * Constructs an instance of <code>Robot</code>
     * with the initial position in the plateau.
     *
     * @param xPos initial position in X
     * @param yPos initial position in X
     * @param look initial look for the Rover
     */
    Robot(int xPos, int yPos, Look look) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.look = look;
    }

    /**
     * Method that move the rover one step across the plateau,
     * If the Rover reach an border, it doesn't move.
     *
     * @param xMax Max X coordinate in the plateau
     * @param yMax Max Y coordinate in the plateau
     * @return
     */
    def goForward(xMax = null, yMax = null) {
        switch (look) {
            case Look.NORTH:
                if (!yMax || yMax > yPos)
                    yPos++;
                break;
            case Look.SOUTH:
                if (0 < yPos)
                    yPos--;
                break;
            case Look.EAST:
                if (!xMax || xMax > xPos)
                    xPos++;
                break;
            case Look.WEST:
                if (0 < xPos)
                    xPos--;
                break;
        }
    }

    /**
     * Method that parse the receive an instruction {character},
     * and move the rover Forward or spin 90 degrees
     *
     * @param character letter with the order to move the rover
     * @param xMax Max X coordinate in the plateau
     * @param yMax Max Y coordinate in the plateau
     * @return
     */
    def move(String character, xMax = null, yMax = null) {
        if (character?.equalsIgnoreCase("L")) {
            switch (look) {
                case Look.NORTH:
                    look = Look.WEST;
                    break;
                case Look.SOUTH:
                    look = Look.EAST;
                    break;
                case Look.EAST:
                    look = Look.NORTH;
                    break;
                case Look.WEST:
                    look = Look.SOUTH;
                    break;
            }
        } else if (character?.equalsIgnoreCase("R")) {
            switch (look) {
                case Look.NORTH:
                    look = Look.EAST;
                    break;
                case Look.SOUTH:
                    look = Look.WEST;
                    break;
                case Look.EAST:
                    look = Look.SOUTH;
                    break;
                case Look.WEST:
                    look = Look.NORTH;
                    break;
            }
        } else if (character?.equalsIgnoreCase("M")) {
            goForward(xMax, yMax);
        } else {
            throw new RuntimeException("Invalid Move Character '${character}'");
        }
    }

    /**
     * Override the toString method
     * @return an String representation for the rovers
     */
    String toString() {
        "${xPos} ${yPos} ${look.getCharacter()}";
    }
}
