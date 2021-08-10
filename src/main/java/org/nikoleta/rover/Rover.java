package org.nikoleta.rover;

import java.util.Arrays;
import java.util.List;

public class Rover {

    private String direction;

    private final static List<String> compass = Arrays.asList("N", "E", "S", "W");
    private final static List<String> reverseCompass = Arrays.asList("N", "W", "S", "E");
    private int positionX;
    private int positionY;

    public Rover(String direction) {

        this.direction = direction;
    }

    public Rover(int positionX, int positionY, String direction) {

        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }

    public String getDirection() {
        return this.direction;
    }

    public void go(String instructions) {

        if (instructions.equals("R")) {
            turn(compass);
        } else if (instructions.equals("L")){
            turn(reverseCompass);
        } else if (instructions.equals("F")){
            if (this.direction.equals("N")) {
                this.positionY = this.positionY + 1;
            } else if (this.direction.equals("E")) {
                this.positionX = this.positionX + 1;
            } else if (this.direction.equals("W")) {
                this.positionX = this.positionX - 1;
            } else {
                this.positionY = this.positionY -1;
            }
        } else {
            if (this.direction.equals("N")) {
                this.positionY = this.positionY - 1;
            } else if (this.direction.equals("S")) {
                this.positionY = this.positionY + 1;
            } else if (this.direction.equals("E")) {
                this.positionX = this.positionX - 1;
            } else {
                this.positionX = this.positionX + 1;
            }
        }
    }

    private void turn(List<String> compass) {
        int currentDirectionIndex = compass.indexOf(this.direction);
        this.direction = compass.get((currentDirectionIndex + 1) % 4);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
