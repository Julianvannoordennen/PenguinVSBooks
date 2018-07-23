package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Explosion;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class GrenadeExplosion extends Explosion {

    public GrenadeExplosion(Transform transform, ProjectileList projectileList) {
        super(transform, projectileList);
    }
}
