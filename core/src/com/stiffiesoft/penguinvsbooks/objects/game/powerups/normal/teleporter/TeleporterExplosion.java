package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.teleporter;

import com.badlogic.gdx.graphics.Color;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Explosion;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class TeleporterExplosion extends Explosion {

    public TeleporterExplosion(Transform transform, GameContext context) {
        super(transform, context);

        //Change explosion color
        color = new Color(0.1f,0.1f,0.75f,1);
        this.decreaseSpeed = 10f;
    }
}
