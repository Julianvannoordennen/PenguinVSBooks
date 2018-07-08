package com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;

import java.util.ArrayList;

public class EnemyList implements Renderable {

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
