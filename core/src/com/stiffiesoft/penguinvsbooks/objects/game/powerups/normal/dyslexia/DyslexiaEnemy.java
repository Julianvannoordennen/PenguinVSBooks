package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.dyslexia;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class DyslexiaEnemy extends LinearProjectile {

    private SpriteAnimation animation;
    private Enemy nearestEnemy;
    private EnemyList enemyList;
    private int health;
    private Transform playerTransform;
    private Vector2 playerDifference;

    public DyslexiaEnemy(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);
        animation           = new SpriteAnimation(A.m.get(A.dyslexiaEnemy),20);
        speed               = C.pH() * 10;
        enemyList           = context.getEnemyList();
        nearestEnemy        = enemyList.getNearest(transform.getPosition());
        health              = 150;
        playerTransform     = context.getPlayer().getTransform();
        playerDifference    = new Vector2(MathUtils.random(-C.pW() * 32, C.pW() * 32), MathUtils.random(-C.pH() * 18, C.pH() * 18));
        setMovementAngle();
    }

    private void setMovementAngle() {

        //Check if the enemy still exists
        if (!enemyList.getArray().contains(nearestEnemy)) {

            //Get the nearest enemy
            Vector2 searchPosition = new Vector2(playerDifference);
            searchPosition.add(playerTransform.getPosition());
            nearestEnemy = enemyList.getNearest(searchPosition);

        } else

            //Move towards the enemy
            transform.setMovementAngle(C.getAngleInRadians(transform.getPositionCenter(), nearestEnemy.getTransform().getPosition()));
    }

    @Override
    public void update() {

        //Set movement angle
        setMovementAngle();

        //Update the animation
        animation.update();

        //Move in correct direction
        super.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw the animation
        animation.render(batch, transform);
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {

        //Decrease health
        health--;

        //Check if there is any health left
        if (health <= 0) {

            //Create junk
            junkFactory.createDyslexiaJunk(transform.clone());
            junkFactory.createDyslexiaJunk(transform.clone());

            //Destroy
            projectileList.destroy(this);
        }

        //Create junk
        junkFactory.createDyslexiaJunk(transform.clone());
    }

    @Override
    public boolean outsideAllowed() {
        return true;
    }

    @Override
    public int getDepth() {
        return DepthProfiles.ENEMIES;
    }
}
