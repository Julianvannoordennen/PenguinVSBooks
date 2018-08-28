package com.stiffiesoft.penguinvsbooks.objects.game.statistics;

public class Statistic {

    private int value;

    public Statistic() {
        this.value  = 0;
    }

    public void increase() {
        this.value += 1;
    }

    public void decrease() {
        this.value -= 1;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
