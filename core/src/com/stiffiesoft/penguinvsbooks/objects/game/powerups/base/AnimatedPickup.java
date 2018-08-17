package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public abstract class AnimatedPickup extends Pickup {

    protected SpriteAnimation animation;

    public AnimatedPickup(Transform transform, GameContext context) {
        super(transform, context);
        animation = null;
    }

    @Override
    public void update() {

        //Update super
        super.update();

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
}
