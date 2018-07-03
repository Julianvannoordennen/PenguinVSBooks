package com.stiffiesoft.penguinvsbooks.gameobjects.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class EnemyList {

    private ArrayList<Enemy> enemies;

    public EnemyList() {
        enemies = new ArrayList<>();
    }

    public void add(Enemy enemy) {
        enemies.add(enemy);
    }

    public void render(SpriteBatch batch) {
        for(Enemy enemy : enemies)
            enemy.render(batch);
    }
}
