package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.hacker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class HackerPickup  extends Pickup {

    private SpriteAnimation animation;

    public HackerPickup(Transform transform, GameContext context) {
        super(transform, context);
        animation = new SpriteAnimation(A.m.get(A.hackerPickup), 30);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createHackerPowerup(transform);
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
