package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.grenade;

import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Explosion;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class GrenadeExplosion extends Explosion {

    public GrenadeExplosion(Transform transform, GameContext context) {
        super(transform, context);
    }
}
