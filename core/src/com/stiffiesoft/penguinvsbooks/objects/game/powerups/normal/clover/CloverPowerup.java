package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.clover;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class CloverPowerup  extends Powerup {

    private int amount;
    private PickupFactory pickupFactory;

    public CloverPowerup(GameContext context, Transform initial) {
        super(context, initial);
        amount          = MathUtils.random(1,3);
        pickupFactory   = context.getPickupFactory();
        start();
    }

    @Override
    protected void start() {

        //Create random pickups
        while (amount > 0) {

            //Define position near pickup itself
            Vector2 position = new Vector2(initial.getPosition());
            float range = C.pH() * 15;
            while (position.dst(initial.getPosition()) < C.pH() * 10)
                position.add(new Vector2(MathUtils.random(-range, range), MathUtils.random(-range,range)));

            //Create pickup and junk
            pickupFactory.forceSpawn(position);
            Transform junkTransform = initial.clone();
            junkTransform.setPosition(position);
            junkFactory.createCloverJunk(junkTransform);

            //Decrease amount
            amount--;
        }

        //Done, destroy
        powerupList.destroy(this);
    }

    @Override
    protected void update() {}
}
