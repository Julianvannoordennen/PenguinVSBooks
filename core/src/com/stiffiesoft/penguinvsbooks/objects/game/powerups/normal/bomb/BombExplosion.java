package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.bomb;

import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Explosion;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class BombExplosion extends Explosion {

    public BombExplosion(Transform transform, GameContext context) {
        super(transform, context);
    }
}
