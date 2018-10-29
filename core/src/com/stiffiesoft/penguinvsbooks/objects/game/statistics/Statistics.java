package com.stiffiesoft.penguinvsbooks.objects.game.statistics;

import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyStatisticsGroup;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkStatisticsGroup;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerStatisticsGroup;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectilesStatisticsGroup;

public class Statistics {

    private EnemyStatisticsGroup enemyStatistics;
    private JunkStatisticsGroup junkStatistics;
    private PlayerStatisticsGroup playerStatisticsGroup;
    private ProjectilesStatisticsGroup projectilesStatisticsGroup;

    public Statistics() {
        initialize();
    }

    private void initialize() {

        //Create groups
        enemyStatistics                 = new EnemyStatisticsGroup();
        junkStatistics                  = new JunkStatisticsGroup();
        playerStatisticsGroup           = new PlayerStatisticsGroup();
        projectilesStatisticsGroup      = new ProjectilesStatisticsGroup();
    }

    public EnemyStatisticsGroup getEnemyStatistics() {
        return enemyStatistics;
    }
    public JunkStatisticsGroup getJunkStatistics() {
        return junkStatistics;
    }
    public PlayerStatisticsGroup getPlayerStatisticsGroup() {
        return playerStatisticsGroup;
    }
    public ProjectilesStatisticsGroup getProjectilesStatisticsGroup() {
        return projectilesStatisticsGroup;
    }

    @Override
    public String toString() {
        return  "#### Statistics ####" +
                "\n\n" + enemyStatistics.toString() +
                "\n\n" + junkStatistics.toString() +
                "\n\n" + playerStatisticsGroup.toString() +
                "\n\n" + projectilesStatisticsGroup.toString() +
                "\n\n\n";
    }
}
