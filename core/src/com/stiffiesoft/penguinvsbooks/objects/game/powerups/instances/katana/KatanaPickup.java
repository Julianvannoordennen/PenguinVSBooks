package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.FramePickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class KatanaPickup extends FramePickup {

    public KatanaPickup(Transform transform, GameContext context) {
        super(transform, context);
        texture = A.m.get(A.katanaPickup);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createKatanaPowerup(transform);
    }
}