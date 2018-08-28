package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.scoremultiplier;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.FramePickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;

public class ScoreMultiplierPickup extends FramePickup {

    public ScoreMultiplierPickup(Transform transform, GameContext context) {
        super(transform, context);
        texture = A.m.get(A.scoreMultiplierPickup);
    }

    @Override
    public void onPickup() {

        //Create the powerup using the powerup factory
        powerupFactory.createScoreMultiplierPowerup(transform);
    }
}
