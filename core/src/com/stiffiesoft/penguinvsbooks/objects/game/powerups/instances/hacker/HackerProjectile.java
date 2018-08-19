package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.hacker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class HackerProjectile implements Projectile, Transformable, GameObject {

    private Transform transform;
    private SpriteAnimation animation;
    private ProjectileList projectileList;
    private EnemyList enemyList;
    private Enemy enemy;
    private long destroyTime;

    public HackerProjectile(Transform transform, GameContext context) {

        //Save values
        this.enemy              = null;
        this.transform          = transform;
        this.projectileList     = context.getProjectileList();
        this.enemyList          = context.getEnemyList();
        this.destroyTime        = TimeUtils.millis() + 3000;
        this.animation          = new SpriteAnimation(A.m.get(A.hackerProjectile), 1);
        this.animation.reverse();
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public void update() {

        //Check if enemy is not null
        if (this.enemy != null && this.animation != null) {

            //Get position from enemy
            this.transform.setPosition(this.enemy.getTransform().getPosition());

            //Check if the enemy still exists
            if (!this.enemyList.getArray().contains(this.enemy))

                //Destroy itself
                this.projectileList.destroy(this);

            //Check if it is time to die
            if (TimeUtils.millis() > this.destroyTime) {

                //Change animation
                enemy.setAnimation(new SpriteAnimation(A.m.get(A.hackerEnemy), 16));
                this.animation = null;

                //Add time
                this.destroyTime = TimeUtils.millis() + 500;
            }
        } else {

            //Check if it is time to die
            if (TimeUtils.millis() > this.destroyTime) {

                //Destroy enemy and self
                this.enemy.die();

                //Destroy itself
                this.projectileList.destroy(this);
            }
        }

        //Update animation
        if (animation != null)
            animation.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw powerup sprite
        if (animation != null)
            animation.render(batch, transform);
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public Body getBody() {
        return null;
    }

    @Override
    public boolean doesDamage() {
        return false;
    }

    @Override
    public boolean outsideAllowed() {
        return true;
    }

    @Override
    public int getDepth() {
        return DepthProfiles.PROJECTILES_FOREGROUND;
    }
}
