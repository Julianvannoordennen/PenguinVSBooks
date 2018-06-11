package com.stiffiesoft.penguinvsbooks.gameobjects.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.system.A;
import com.stiffiesoft.penguinvsbooks.system.C;
import com.stiffiesoft.penguinvsbooks.system.Transform;
import com.stiffiesoft.penguinvsbooks.system.Transformable;

public class DefaultBookEnemy implements Transformable {

    private SpriteAnimation currentSpriteAnimation;
    private Transform transform;
    private EnemyTargetUpdater targetUpdater;

    public DefaultBookEnemy() {

        //Transform
        transform = new Transform(32,32,C.pH() * 5, C.pH() * 5,1,1,45);

        //Sprite Animation
        currentSpriteAnimation = new SpriteAnimation(A.m.get(A.defaultBookEnemyAtlas),30);


        //Enemy target updater
        this.targetUpdater = new EnemyTargetUpdater(this);
    }

    public void render(SpriteBatch batch) {

        //Render animation
        currentSpriteAnimation.render(batch, transform);

        //Move towards enemy

    }

    @Override
    public Transform getTransform() {
        return transform;
    }
}
