package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public abstract class FramePickup extends Pickup {

    protected Texture texture;

    public FramePickup(Transform transform, GameContext context) {
        super(transform, context);
        texture = null;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw powerup sprite
        if (texture != null)
            Transform.draw(batch, texture, transform);
    }
}
