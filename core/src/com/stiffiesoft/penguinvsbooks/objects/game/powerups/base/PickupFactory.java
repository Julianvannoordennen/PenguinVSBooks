package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.GrenadePickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;

public class PickupFactory {

    private PickupList pickupList;
    private BodyFactory bodyFactory;
    private PowerupFactory powerupFactory;

    public PickupFactory(BodyFactory bodyFactory, PowerupFactory powerupFactory) {
        this.pickupList = new PickupList();
        this.powerupFactory = powerupFactory;
        this.bodyFactory = bodyFactory;
    }

    public GrenadePickup createGrenadePickup(Vector2 position) {

        //Create default transform for pickup
        Transform transform = new Transform(position.x, position.y,C.pH() * 5, C.pH() * 5,1,1,0);

        //Create pickup and apply the transform send in parameter
        GrenadePickup pickup = new GrenadePickup(transform, powerupFactory, pickupList);

        //Add pickup to the list so the program can keep track of it
        pickupList.add(pickup);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Return to projectile
        return pickup;
    }

    public PickupList getPickupList() {
        return pickupList;
    }
}
