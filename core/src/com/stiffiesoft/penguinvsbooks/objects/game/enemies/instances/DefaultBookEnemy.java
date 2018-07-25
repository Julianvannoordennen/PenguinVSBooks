package com.stiffiesoft.penguinvsbooks.objects.game.enemies.instances;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetUpdater;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.collision.CollisionTypes;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class DefaultBookEnemy implements Transformable, Enemy, Collidable {

    private SpriteAnimation currentSpriteAnimation;
    private Transform transform;
    private EnemyTargetUpdater targetUpdater;
    private float defaultMovementSpeed;
    private float currentMovementSpeed;
    private Body body;
    private EnemyList enemyList;
    private JunkFactory junkFactory;

    public DefaultBookEnemy(GameContext context) {

        //Transform
        transform = new Transform(256, 256, C.pH() * 5, C.pH() * 5, 1, 1, 0);
        defaultMovementSpeed    = 50;
        currentMovementSpeed    = defaultMovementSpeed;

        //Create properties
        currentSpriteAnimation  = new SpriteAnimation(A.m.get(A.defaultBookEnemyAtlas), 30);
        this.targetUpdater      = new EnemyTargetUpdater(this);
        this.enemyList          = context.getEnemyList();
        this.junkFactory        = context.getJunkFactory();
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

        //Update body
        Transform.pushInBody(transform, body);
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public void onCollisionEnter(Collidable other, short type) {

        //Check if it's a projectile
        if (type == CollisionTypes.PROJECTILE) {

            //Cast to projectile
            Projectile projectile = (Projectile)other;

            //Check if projectile does damage
            if (projectile.doesDamage()) {

                //Create junk
                junkFactory.createDefaultEnemyDyingJunk(transform);

                //Destroy enemy
                enemyList.destroy(this);
            }
        }
    }

    @Override
    public Body getBody() {
        return body;
    }


    @Override
    public void setBody(Body body) {
        this.body = body;
    }
}
