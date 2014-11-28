package com.christancho.mars

/**
 * Test Class for the Mars.groovy
 *
 * @author Christian Delgado
 * @version 1.0
 * @date 11/23/14
 */
class MarsTest extends GroovyTestCase {

    Mars instance;

    void setUp() {
        super.setUp()
        instance = new Mars();
    }

    void tearDown() {

    }

    void testDeployRovers() {
        System.out.println("test deployRovers");
        instance.deployRovers("5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
        System.out.println("return: " + instance);

    }
}
