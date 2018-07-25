package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Explosion;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class PlayerDamageExplosion extends Explosion {

    public PlayerDamageExplosion(Transform transform, GameContext context) {
        super(transform, context);
        color = new Color(1f,0.5f,0.5f,1);
    }
}
