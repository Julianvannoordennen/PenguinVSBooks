package com.stiffiesoft.penguinvsbooks.objects.game.statistics;

public class Statistics {

    private EnemyStatisticsGroup enemyStatistics;
    private JunkStatisticsGroup junkStatistics;

    public Statistics() {
        initialize();
    }

    private void initialize() {

        //Create groups
        enemyStatistics         = new EnemyStatisticsGroup();
        junkStatistics          = new JunkStatisticsGroup();
    }

    public EnemyStatisticsGroup getEnemyStatistics() {
        return enemyStatistics;
    }
    public JunkStatisticsGroup getJunkStatistics() {
        return junkStatistics;
    }

    @Override
    public String toString() {
        return  "#### Statistics ####" +
                "\n\n" + enemyStatistics.toString() +
                "\n\n" + junkStatistics.toString() +
                "\n\n\n";
    }
}
