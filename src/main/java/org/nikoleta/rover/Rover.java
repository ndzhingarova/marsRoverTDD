package org.nikoleta.rover;

import java.util.Arrays;
import java.util.List;

public class Rover {


    private String direction;
    private List<String> compass = Arrays.asList("N", "E", "S", "W");

    public Rover(String direction) {

        this.direction = direction;
    }

    public String getDirection() {
        return this.direction;
    }

    public void go(String instructions) {
        int currentDirectionIndex = compass.indexOf(this.direction);

        this.direction = compass.get((currentDirectionIndex +1) % 4);
    }
}
