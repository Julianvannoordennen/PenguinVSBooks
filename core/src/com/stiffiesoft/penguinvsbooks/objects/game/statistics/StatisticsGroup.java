package com.stiffiesoft.penguinvsbooks.objects.game.statistics;

public abstract class StatisticsGroup {

    public StatisticsGroup() {
        initialize();
    }

    protected abstract void initialize();

    @Override
    public abstract String toString();
}
