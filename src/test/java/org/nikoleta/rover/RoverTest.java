package org.nikoleta.rover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoverTest {

    @ParameterizedTest
    @CsvSource({"N,E", "E,S", "S,W", "W,N"})
    public void turnRightClockwise(String initialDirection, String expectedDirection) {
        Rover rover = new Rover(initialDirection);
        rover.go("R");

        Assertions.assertEquals(expectedDirection, rover.getDirection());
    }

    @ParameterizedTest
    @CsvSource({ "N,W", "W,S", "S,E", "E,N" })
    public void turnLeftCounterClockwise(String initialDirection, String expectedDirection) {
        Rover rover = new Rover(initialDirection);
        rover.go("L");

        Assertions.assertEquals(expectedDirection, rover.getDirection());
    }

    @ParameterizedTest
    @CsvSource({"W,9", "E,11"})
    public void moveForwardXAxis(String direction, int expectedPosition) {
        Rover rover = new Rover(10,10, direction);
        rover.go("F");

        Assertions.assertEquals(expectedPosition, rover.getPositionX());
    }

    @ParameterizedTest
    @CsvSource({"S,9", "N,11"})
    public void moveForwardYAxis(String direction, int expectedPosition) {
        Rover rover = new Rover(10,10, direction);
        rover.go("F");

        Assertions.assertEquals(expectedPosition, rover.getPositionY());
    }

    @ParameterizedTest
    @CsvSource({"N,9","S,11"})
    public void moveBackwardYAxis(String direction, int expectedPosition) {
        Rover rover = new Rover(10,10, direction);
        rover.go("B");

        Assertions.assertEquals(expectedPosition, rover.getPositionY());
    }

    @ParameterizedTest
    @CsvSource({"E,9","W,11"})
    public void moveBackwardXAxis(String direction, int expectedPosition) {
        Rover rover = new Rover(10,10, direction);
        rover.go("B");

        Assertions.assertEquals(expectedPosition, rover.getPositionX());
    }

    @Test
    public void processInstructionSequence() {
        Rover rover = new Rover(10,10,"N");
        rover.go("FRF");

        Assertions.assertEquals(11, rover.getPositionX());
        Assertions.assertEquals(11, rover.getPositionY());
        Assertions.assertEquals("E", rover.getDirection());
    }
    @Test
    public void throwsOnInvalidInstruction() {
        Rover rover = new Rover(10,10,"N");

        Assertions.assertThrows(InvalidInstructionException.class,
                () ->rover.go("A"));
    }
}
