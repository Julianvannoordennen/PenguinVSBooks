package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class PlayerProjectile extends LinearProjectile {

    private float rotateSpeed;

    public PlayerProjectile(Transform transform, ProjectileList projectileList) {

        //Use the default settings from the projectile
        super(transform, projectileList);

        //Set rotate speed
        rotateSpeed = 250;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Rotate the sprite, for design purposes
        transform.rotate(rotateSpeed * C.cGT());

        //Draw player sprite
        Transform.draw(batch, A.m.get(A.playerProjectile), transform);
        super.render(batch);
    }
}
