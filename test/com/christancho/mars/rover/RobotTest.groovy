package com.christancho.mars.rover

/**
 * Test Class for the Robot.groovy
 *
 * @author Christian Delgado
 * @version 1.0
 * @date 11/23/14
 */
class RobotTest extends GroovyTestCase {

    def instance;

    void setUp() {
        super.setUp()
        instance = new Robot(1, 3, Look.EAST);
    }

    void testGoForward() {
    }

    void testMove() {
        System.out.println("test move");
        System.out.println("1 Position: '${instance}'");
        instance.move("R");
        System.out.println("2 Position: '${instance}'");
        instance.move("M");
        System.out.println("3 Position: '${instance}'");
        instance.move("L");
        System.out.println("4 Position: '${instance}'");
        instance.move("M");
        System.out.println("5 Position: '${instance}'");
    }
}
