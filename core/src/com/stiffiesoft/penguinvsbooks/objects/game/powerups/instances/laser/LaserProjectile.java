package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public class LaserProjectile extends LinearProjectile {

    private float defaultXScale;
    private float flashIntensity;
    private Color color;
    private long destroyTime;
    private long flashTime;
    private ScreenFlasher screenFlasher;

    public LaserProjectile(Transform transform, ProjectileList projectileList, ScreenFlasher screenFlasher) {

        //Use the default settings from the projectile
        super(transform, projectileList);
        this.screenFlasher = screenFlasher;

        //Disable speed
        speed = 0;

        //Apply some other default settings
        defaultXScale = 1;
        flashIntensity = 0;
        color = Color.CLEAR;
        destroyTime = TimeUtils.millis() + 3000; //Laser lasts 3 seconds
        flashTime = TimeUtils.millis();
    }

    private void updateFlashTime() {
        flashTime = TimeUtils.millis() + 100; //Flash every 0.1 seconds
    }

    @Override
    public void render(SpriteBatch batch) {

        //Move
        super.render(batch);

        //Flash scale
        transform.setXScale(defaultXScale + MathUtils.random(0f, flashIntensity));

        //Get default color
        Color color = batch.getColor();

        //Change color
        batch.setColor(new Color(this.color.r, this.color.g, this.color.b, 1));

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.laserPowerup), transform);

        //Restore color
        batch.setColor(color);

        //Check if duration is done
        if (TimeUtils.millis() > destroyTime)

            //Destroy laser
            projectileList.destroy(this);

        //Check for flash
        if (TimeUtils.millis() > flashTime) {

            //Update flash time
            updateFlashTime();

            //Flash screen
            screenFlasher.flash(new Color(this.color.r,this.color.b,this.color.g,0.5f));
        }

    }

    public void setMovement(boolean horizontal, float speed) {
        transform.setMovementAngle(C.degreesToRadians(horizontal ? 0 : 90));
        this.speed = speed;
    }

    public void setFlashSize(float defaultXScale, float flashIntensity) {
        this.defaultXScale = defaultXScale;
        this.flashIntensity = flashIntensity;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {}
}
