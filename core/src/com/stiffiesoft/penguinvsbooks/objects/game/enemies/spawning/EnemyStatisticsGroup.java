package com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning;

import com.stiffiesoft.penguinvsbooks.objects.game.statistics.Statistic;
import com.stiffiesoft.penguinvsbooks.objects.game.statistics.StatisticsGroup;

public class EnemyStatisticsGroup extends StatisticsGroup {

    //Enemy statistics
    private Statistic enemiesSpawned;
    private Statistic enemiesDied;
    private Statistic enemiesOnScreen;

    @Override
    protected void initialize() {

        //Enemy statistics
        enemiesSpawned              = new Statistic();
        enemiesDied                 = new Statistic();
        enemiesOnScreen             = new Statistic();
    }

    @Override
    public String toString() {
        return  "-- Enemy Statistics --" +
                "\nEnemies spawned = "          + enemiesSpawned.getValue() +
                "\nEnemies died = "             + enemiesDied.getValue() +
                "\nEnemies on screen = "        + enemiesOnScreen.getValue();
    }

    public Statistic getEnemiesSpawned() {
        return enemiesSpawned;
    }
    public Statistic getEnemiesDied() {
        return enemiesDied;
    }
    public Statistic getEnemiesOnScreen() {
        return enemiesOnScreen;
    }
}
