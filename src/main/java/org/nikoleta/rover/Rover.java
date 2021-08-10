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
        String[] instructionsArray = instructions.split("");

        for (String instruction : instructionsArray) {
            switch (instruction) {
                case "R":
                    turn(compass);
                    break;
                case "L":
                    turn(reverseCompass);
                    break;
                case "F":
                    moveForward();
                    break;
                default:
                    moveBackward();
                    break;
            }
        }
    }

    private void moveBackward() {
        switch (this.direction) {
            case "N":
                this.positionY = this.positionY - 1;
                break;
            case "S":
                this.positionY = this.positionY + 1;
                break;
            case "E":
                this.positionX = this.positionX - 1;
                break;
            default:
                this.positionX = this.positionX + 1;
                break;
        }
    }

    private void moveForward() {
        switch (this.direction) {
            case "N":
                this.positionY = this.positionY + 1;
                break;
            case "E":
                this.positionX = this.positionX + 1;
                break;
            case "W":
                this.positionX = this.positionX - 1;
                break;
            default:
                this.positionY = this.positionY - 1;
                break;
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
