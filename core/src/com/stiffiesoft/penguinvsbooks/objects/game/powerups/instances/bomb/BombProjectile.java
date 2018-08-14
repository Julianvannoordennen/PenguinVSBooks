package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

public class BombProjectile extends LinearProjectile {

    private SpriteAnimation animation;
    private ProjectileFactory projectileFactory;
    private JunkFactory junkFactory;

    public BombProjectile(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);
        projectileFactory   = context.getProjectileFactory();
        animation           = new SpriteAnimation(A.m.get(A.bombProjectile), 30);
        speed               = C.pH() * 50;
        junkFactory         = context.getJunkFactory();

        //Change movement angle
        Player player = context.getPlayer();
        if (player != null) {
            transform.setMovementAngle(C.degreesToRadians(player.getTransform().getRotation()));
            transform.setRotation(player.getTransform().getRotation());
        }
    }

    @Override
    public void update() {

        //Execute super
        super.update();

        //Create junk
        junkFactory.createRollingBombJunk(transform);

        //Update animation
        animation.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw projectile sprite
        animation.render(batch, transform);
    }

    @Override
    public boolean outsideAllowed() {
        return false;
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {

        //Create explosion
        projectileFactory.createBombExplosion(transform);

        //Destroy self
        projectileList.destroy(this);
    }
}
