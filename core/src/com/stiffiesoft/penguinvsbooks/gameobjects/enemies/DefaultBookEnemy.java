package com.stiffiesoft.penguinvsbooks.gameobjects.enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.system.A;
import com.stiffiesoft.penguinvsbooks.system.C;
import com.stiffiesoft.penguinvsbooks.system.Transform;
import com.stiffiesoft.penguinvsbooks.system.Transformable;

public class DefaultBookEnemy implements Transformable, Enemy {

    private SpriteAnimation currentSpriteAnimation;
    private Transform transform;
    private EnemyTargetUpdater targetUpdater;
    private float defaultMovementSpeed;
    private float currentMovementSpeed;

    public DefaultBookEnemy() {

        //Transform
        transform = new Transform(256,256,C.pH() * 5, C.pH() * 5,1,1,0);
        defaultMovementSpeed = 50;
        currentMovementSpeed = defaultMovementSpeed;

        //Sprite Animation
        currentSpriteAnimation = new SpriteAnimation(A.m.get(A.defaultBookEnemyAtlas),30);

        //Enemy target updater
        this.targetUpdater = new EnemyTargetUpdater(this);
    }

    public void render(SpriteBatch batch) {

        //Update targetting system
        targetUpdater.update();

        //Render animation
        currentSpriteAnimation.render(batch, transform);

        //Set movement angle
        Transformable target = targetUpdater.getTarget();
        if (target != null) {
            Vector2 targetPosition = target.getTransform().getPositionCenter();
            transform.setMovementAngle(C.getAngleInRadians(transform.getPositionCenter(), targetPosition));
        }

        //Move towards target
        transform.moveInDirection( currentMovementSpeed * C.cGT());
    }

    @Override
    public Transform getTransform() {
        return transform;
    }
}
