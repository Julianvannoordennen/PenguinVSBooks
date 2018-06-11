package com.stiffiesoft.penguinvsbooks.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.DefaultBookEnemy;
import com.stiffiesoft.penguinvsbooks.gameobjects.enemies.TargetTest;
import com.stiffiesoft.penguinvsbooks.system.A;
import com.stiffiesoft.penguinvsbooks.system.C;

public class Game extends BaseScene {

    private DefaultBookEnemy enemy;
    private TargetTest targetTest;

    public Game(Main main) {
        super(main);
        targetTest = new TargetTest();
        enemy = new DefaultBookEnemy();
    }

    @Override
    protected void onRender(SpriteBatch batch) {
        enemy.render(batch);
        targetTest.draw(batch);
    }

    @Override
    protected void onDispose() {
    }
}
