package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.magnet;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupList;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class MagnetPowerup extends Powerup {

    private PickupList pickupList;
    private float powerupRange;
    private Pickup creator;
    private ProjectileFactory projectileFactory;

    public MagnetPowerup(GameContext context, Pickup creator, Transform initial) {
        super(context, initial);
        this.powerupRange       = C.pH() * 100;
        this.pickupList         = context.getPickupList();
        this.projectileFactory  = context.getProjectileFactory();
        this.creator            = creator;
        start();
    }

    @Override
    protected void start() {

        //Find all the powerups that are near
        for (Pickup pickup : pickupList.get()) {

            //Check if near
            if (initial.getPosition().dst(pickup.getTransform().getPosition()) < this.powerupRange && pickup != creator)

                //This pickup is good, add a shock projectile to it
                projectileFactory.createMagnetShock(pickup);
        }

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {
    }
}
