package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.wizard;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class WizardEnemy extends LinearProjectile {

    private SpriteAnimation animation;
    private int fireAmount;
    private int fired;
    private int attackTimes;
    private long fireRate;
    private long nextFire;
    private float defaultSpeed;
    private Vector2 targetPosition;
    private ProjectileFactory projectileFactory;

    public WizardEnemy(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);
        animation           = new SpriteAnimation(A.m.get(A.wizardEnemy),20);
        defaultSpeed        = C.pH() * 20;
        fireAmount          = 60;
        fireRate            = 100;
        nextFire            = TimeUtils.millis();
        fired               = 0;
        attackTimes         = 3;
        projectileFactory   = context.getProjectileFactory();
        targetPosition      = transform.getPosition();
        generateTargetPosition();
    }

    private void generateTargetPosition() {

        //Save old position
        Vector2 oldPosition = new Vector2(targetPosition);
        Vector2 newPosition = new Vector2(targetPosition);

        //Get new target
        while (oldPosition.dst(newPosition) < C.pW() * 25)
            newPosition = new Vector2(MathUtils.random(C.pW() * 2, C.pW() * 98), MathUtils.random(C.pH() * 2, C.pH() * 98));

        //Assign new position
        targetPosition = new Vector2(newPosition);

        //Move towards the enemy
        transform.setMovementAngle(C.getAngleInRadians(transform.getPositionCenter(), targetPosition));
        speed = defaultSpeed;
    }

    @Override
    public void update() {

        //Update the animation
        animation.update();

        //Check distance between wizard and target
        if (targetPosition.dst(transform.getPosition()) < C.pW() * 5) {

            //No speed
            speed = 0;

            //Check time
            if (TimeUtils.millis() > nextFire) {

                //Fire projectile
                transform.setMovementAngle(MathUtils.random(0,359));
                projectileFactory.createWizardProjectile(transform.clone());

                //Increase fired
                nextFire = TimeUtils.millis() + fireRate;
                fired++;

                //Fired enough?
                if (fired >= fireAmount) {

                    //Lower attack times
                    attackTimes--;
                    fired = 0;

                    //Check if it is time to die
                    if (attackTimes <= 0) {

                        //Create enemy junk
                        junkFactory.createDefaultEnemyDyingJunk(transform.clone());

                        //Destroy itself
                        projectileList.destroy(this);

                    } else

                        //Generate new position
                        generateTargetPosition();
                }
            }
        }

        //Move in correct direction
        super.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw the animation
        animation.render(batch, transform);
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
