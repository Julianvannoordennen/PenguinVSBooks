package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.stiffiesoft.penguinvsbooks.objects.game.statistics.Statistic;
import com.stiffiesoft.penguinvsbooks.objects.game.statistics.StatisticsGroup;

public class PlayerStatisticsGroup extends StatisticsGroup {

    //Statistics
    private Statistic projectilesThrown;
    private Statistic timesDamaged;

    @Override
    protected void initialize() {

        //Create statistics
        projectilesThrown   = new Statistic();
        timesDamaged        = new Statistic();
    }

    @Override
    public String toString() {
        return  "-- Player Statistics --" +
                "\nProjectiles thrown = "                       + projectilesThrown.getValue() +
                "\nTimes damaged = "                            + timesDamaged.getValue();
    }

    public Statistic getProjectilesThrown() {
        return projectilesThrown;
    }

    public Statistic getTimesDamaged() {
        return timesDamaged;
    }
}
