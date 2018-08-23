package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.katana;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public class KatanaThrowProjectile extends LinearProjectile {

    private ProjectileFactory projectileFactory;
    private JunkFactory junkFactory;
    private float rotationSpeed;

    public KatanaThrowProjectile(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);
        projectileFactory   = context.getProjectileFactory();
        speed               = C.pH() * 50;
        junkFactory         = context.getJunkFactory();
        rotationSpeed       = 1000;

        //Change movement angle
        Player player = context.getPlayer();
        if (player != null) {
            transform.setMovementAngle(C.degreesToRadians(player.getTransform().getRotation()));
            transform.setRotation(player.getTransform().getRotation());
        }
    }

    @Override
    public void update() {

        //Move in correct direction
        super.update();

        //Rotate katana
        transform.rotate(this.rotationSpeed * C.cGT());
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.katanaPickup), transform);
    }

    @Override
    public boolean outsideAllowed() {
        return false;
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {

        //Create junk
        junkFactory.createKatanaJunk(other.getTransform());
    }
}
