package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.boomerang;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class BoomerangPickup extends Pickup {

    private SpriteAnimation animation;

    public BoomerangPickup(Transform transform, GameContext context) {
        super(transform, context);
        animation = new SpriteAnimation(A.m.get(A.boomerangPickup), 15);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createBoomerangPowerup(transform);
    }

    @Override
    public void update() {

        //Update super
        super.update();

        //Update animation
        animation.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw powerup sprite
        animation.render(batch, transform);
    }
}
