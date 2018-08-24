package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public class ShredderCannonProjectile extends LinearProjectile {

    public ShredderCannonProjectile(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);
        speed = C.pH() * 300;
    }

    @Override
    public void update() {

        //Move in correct direction
        super.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.pickupSpark), transform);
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {
    }

    @Override
    public boolean outsideAllowed() {
        return false;
    }
}
