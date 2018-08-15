package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.earthquake;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class EarthquakePickup extends Pickup {

    public EarthquakePickup(Transform transform, GameContext context) {
        super(transform, context);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createEarthquakePowerup(transform);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw powerup sprite
        Transform.draw(batch, A.m.get(A.earthquakePickup), transform);
    }
}
