package com.christancho.mars.rover

/**
 * This Enum represents the four cardinal compass points
 * where the robot can be heading
 *
 * @author Christian Delgado
 * @version 1.0
 * @date 11/23/14
 */
enum Look implements Serializable {

    NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
    String character;

    Look(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public static Look parseLook(String character) {
        switch (character.toUpperCase()) {
            case "N":
                return NORTH;
            case "S":
                return SOUTH;
            case "E":
                return EAST;
            case "W":
                return WEST;
            default:
                throw new RuntimeException("Invalid Look Character '${character}'");
        }
    }

}
