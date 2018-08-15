package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class CookiePickup extends Pickup {

    private SpriteAnimation animation;

    public CookiePickup(Transform transform, GameContext context) {
        super(transform, context);
        animation = new SpriteAnimation(A.m.get(A.cookiePickup), 30);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createCookiePowerup(transform);
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
