package controller;

public enum Direction {
    UP(0),
    LEFT(1),
    RIGHT(2),
    DOWN(3);


    private final int index;

    Direction(int val) {
        this.index = val;
    }

    public int getIndex() {
        return index;
    }
}
