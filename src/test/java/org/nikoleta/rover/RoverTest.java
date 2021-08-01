package org.nikoleta.rover;

import org.junit.jupiter.api.Assertions;
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
}
