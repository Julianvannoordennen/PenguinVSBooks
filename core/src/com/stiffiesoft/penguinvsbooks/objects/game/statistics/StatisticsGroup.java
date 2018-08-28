package com.stiffiesoft.penguinvsbooks.objects.game.statistics;

public abstract class StatisticsGroup {

    public StatisticsGroup() {
        initialize();
    }

    abstract void initialize();

    @Override
    public abstract String toString();
}
