package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.magnet;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class MagnetShock extends LinearProjectile {

    private SpriteAnimation animation;
    private Player player;
    private Pickup pickup;
    private PickupList pickupList;
    private JunkFactory junkFactory;

    public MagnetShock(Pickup pickup, GameContext context) {

        //Use the default settings from the projectile
        super(pickup.getTransform(), context);
        this.pickup             = pickup;
        this.player             = context.getPlayer();
        this.junkFactory        = context.getJunkFactory();
        this.animation          = new SpriteAnimation(A.m.get(A.magnetShock), 30);
        this.pickupList         = context.getPickupList();
        this.speed              = C.pH() * 50;

        //Create junk
        junkFactory.createTeleporterJunk(pickup.getTransform());
    }

    @Override
    public void update() {

        //Update super
        super.update();

        //Set angle to move to
        transform.setMovementAngle(C.getAngleInRadians(transform.getPosition(), player.getTransform().getPosition()));

        //Move it to the player
        transform.moveInDirection(this.speed * C.cGT());

        //Check if pickup exists in list
        if (!this.pickupList.get().contains(pickup)) {

            //Create junk
            junkFactory.createTeleporterJunk(pickup.getTransform());

            //Destroy projectile
            projectileList.destroy(this);
        }

        //Update animation
        animation.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Render a shock at the pickup
        animation.render(batch, transform);
    }

    @Override
    public boolean outsideAllowed() {
        return true;
    }
}
