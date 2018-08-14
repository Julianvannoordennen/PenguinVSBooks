package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class PlayerProjectile extends LinearProjectile {

    private float rotateSpeed;

    public PlayerProjectile(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);

        //Set rotate speed
        rotateSpeed = 500;
    }

    @Override
    public void update() {

        //Move in correct direction
        super.update();

        //Rotate the sprite, for design purposes
        transform.rotate(rotateSpeed * C.cGT());
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.playerProjectile), transform);
    }

    @Override
    public boolean outsideAllowed() {
        return false;
    }
}
