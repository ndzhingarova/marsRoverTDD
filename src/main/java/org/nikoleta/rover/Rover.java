package org.nikoleta.rover;

import java.util.Arrays;
import java.util.List;

public class Rover {

    private String direction;
    private final List<String> compass = Arrays.asList("N", "E", "S", "W");
    private final List<String> reverseCompass = Arrays.asList("N", "W", "S", "E");

    public Rover(String direction) {

        this.direction = direction;
    }

    public String getDirection() {
        return this.direction;
    }

    public void go(String instructions) {

        if (instructions.equals("R")) {
            turn(compass);
        } else {
            turn(reverseCompass);
        }
    }

    private void turn(List<String> compass) {
        int currentDirectionIndex = compass.indexOf(this.direction);
        this.direction = compass.get((currentDirectionIndex + 1) % 4);
    }
}
