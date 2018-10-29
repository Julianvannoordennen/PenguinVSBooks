package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.stiffiesoft.penguinvsbooks.objects.game.statistics.Statistic;
import com.stiffiesoft.penguinvsbooks.objects.game.statistics.StatisticsGroup;

public class ProjectilesStatisticsGroup extends StatisticsGroup {

    //Enemy statistics
    private Statistic projectilesSpawned;
    private Statistic projectilesDestroyed;
    private Statistic projectilesOnScreen;

    @Override
    protected void initialize() {

        //Enemy statistics
        projectilesSpawned      = new Statistic();
        projectilesDestroyed    = new Statistic();
        projectilesOnScreen     = new Statistic();
    }

    @Override
    public String toString() {
        return  "-- Enemy Statistics --" +
                "\nProjectiles spawned = "                  + projectilesSpawned.getValue() +
                "\nProjectiles destroyed = "                + projectilesDestroyed.getValue() +
                "\nProjectiles on screen = "                + projectilesOnScreen.getValue();
    }

    public Statistic getProjectilesSpawned() {
        return projectilesSpawned;
    }
    public Statistic getProjectilesDestroyed() {
        return projectilesDestroyed;
    }
    public Statistic getProjectilesOnScreen() {
        return projectilesOnScreen;
    }
}
