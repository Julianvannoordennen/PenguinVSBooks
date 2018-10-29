package com.stiffiesoft.penguinvsbooks.objects.game.junk;

import com.stiffiesoft.penguinvsbooks.objects.game.statistics.Statistic;
import com.stiffiesoft.penguinvsbooks.objects.game.statistics.StatisticsGroup;

public class JunkStatisticsGroup extends StatisticsGroup {

    //Statistics
    private Statistic junkCreated;
    private Statistic junkPackagesCreated;
    private Statistic junkOnScreen;

    @Override
    protected void initialize() {

        //Create statistics
        junkCreated                 = new Statistic();
        junkPackagesCreated         = new Statistic();
        junkOnScreen                = new Statistic();
    }

    @Override
    public String toString() {
        return  "-- Junk Statistics --" +
                "\nJunk created = "                     + junkCreated.getValue() +
                "\nJunk packages created = "            + junkPackagesCreated.getValue() +
                "\nJunk on screen = "                   + junkOnScreen.getValue();
    }

    public Statistic getJunkCreated() {
        return junkCreated;
    }
    public Statistic getJunkPackagesCreated() {
        return junkPackagesCreated;
    }
    public Statistic getJunkOnScreen() {
        return junkOnScreen;
    }
}
