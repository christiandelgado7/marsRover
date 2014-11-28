package com.christancho.mars

import com.christancho.mars.rover.Look
import com.christancho.mars.rover.Robot

/**
 * Class that represents the plateau where the rovers are deploy
 *
 * @author Christian Delgado
 * @version 1.0
 * @date 11/23/14
 */
class Mars implements Serializable {

    /**
     * List of rovers deployed in Mars
     */
    List<Robot> rovers;
    /**
     * Max coordinate X in the plateau
     */
    int xMax;
    /**
     * Max coordinate Y in the plateau
     */
    int yMax;

    /**
     * Method that receive the {input} with the instructions for the rovers
     *
     * @param input
     * @return void
     */
    def deployRovers(String input) {
        this.rovers = new ArrayList<>();
        if(input.contains("  ")){
            throw new RuntimeException("Invalid input! The input can't have two consecutive white spaces.")
        }
        def chars = input.trim().split(" ").toList();
        if(chars.size()<6){
            throw new RuntimeException("Invalid input! You have to insert the Max Coordinates, " +
                    "and at least one Rover Path.")
        }
        xMax = Integer.parseInt(chars.remove(0));
        yMax = Integer.parseInt(chars.remove(0));
        for (int i = 0; i < chars.size(); i = i + 4) {
            Robot robot = new Robot(Integer.parseInt(chars[i]),
                    Integer.parseInt(chars[i + 1]),
                    Look.parseLook(chars[i + 2]))
            chars[i + 3].each {
                it -> robot.move(it, xMax, yMax);
            }
            rovers.add(robot);
        }
    }

    /**
     * Override the toString method
     * @return an String representation for the rovers deployed
     */
    String toString() {
        String printString = "";
        rovers.each { it ->
            printString = printString + " ${it}";
        }
        return printString;
    }
}
