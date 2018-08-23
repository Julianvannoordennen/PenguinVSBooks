package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.flamethrower;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public class FlameThrowerProjectile extends LinearProjectile {

    private float intensity;
    private float sizeIncrease;
    private float intensityDecrease;
    private float redNess;
    private BodyFactory bodyFactory;
    private boolean fixtureSwitch;

    public FlameThrowerProjectile(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);
        speed               = C.pH() * 200;
        intensity           = 1;
        sizeIncrease        = C.pH() * 10;
        intensityDecrease   = C.pH() / 2.5f;
        redNess             = MathUtils.random(0.1f, 0.9f);
        bodyFactory         = context.getBodyFactory();
        fixtureSwitch       = false;
        transform.setScale(new Vector2(0,0));
    }

    @Override
    public void update() {

        //Increase size
        float size = transform.getXScale() + (sizeIncrease * C.cGT());
        transform.setScale(new Vector2(size, size));

        //Destroy fixture
        if (fixtureSwitch)
            for (Fixture fixture : body.getFixtureList())
                body.destroyFixture(fixture);

        //Decrease intensity
        intensity -= intensityDecrease * C.cGT();

        //Check if we need to die
        if (intensity <= 0) {

            //Create junk
            junkFactory.createFlameThrowerJunk(transform.clone());

            //Destroy
            projectileList.destroy(this);

        } else {

            //Create new fixture
            if (fixtureSwitch)
                bodyFactory.addTask(new FlameThrowerBodyTask(this, size * 10));

            fixtureSwitch = !fixtureSwitch;
        }

        //Move in correct direction
        super.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Get default color
        Color color = batch.getColor();

        //Change color
        batch.setColor(new Color(redNess, 0, 0, intensity));

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.pickupSpark), transform);

        //Restore color
        batch.setColor(color);
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {

        //Create junk
        junkFactory.createFlameThrowerJunk(transform.clone());

        //Destroy self
        projectileList.destroy(this);
    }

    @Override
    public boolean outsideAllowed() {
        return false;
    }
}
