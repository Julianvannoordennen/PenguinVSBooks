package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.boomerang;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public class BoomerangProjectile extends LinearProjectile {

    private JunkFactory junkFactory;
    private float rotationSpeed;
    private float decreaseSpeed;

    public BoomerangProjectile(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);
        decreaseSpeed       = C.pH() * 250;
        speed               = C.pH() * 200;
        rotationSpeed       = C.pH() * 20;

        //Change movement angle
        Player player = context.getPlayer();
        if (player != null) {
            transform.setPosition(player.getTransform().getPositionCenter());
            transform.setMovementAngle(C.degreesToRadians(player.getTransform().getRotation()));
            transform.setRotation(player.getTransform().getRotation());
        }
    }

    @Override
    public void update() {

        //Move the boomerang
        super.update();

        //Rotate the boomerang
        transform.rotate(rotationSpeed * C.cGT());

        //Decrease the current speed
        speed -= decreaseSpeed * C.cGT();

        //Check if the speed is far negative
        if (speed < C.pH() * -500)

            //Destroy the boomerang
            projectileList.destroy(this);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.boomerangProjectile), transform);
    }

    @Override
    public boolean outsideAllowed() {
        return true;
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {
    }
}