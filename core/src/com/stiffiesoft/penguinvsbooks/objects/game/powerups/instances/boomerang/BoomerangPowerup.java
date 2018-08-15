package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.boomerang;

import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class BoomerangPowerup extends Powerup {

    private int amount;
    private long duration;
    private long nextThrow;

    public BoomerangPowerup(GameContext context, Transform initial) {
        super(context, initial);
        amount      = 5;
        duration    = 250;
        nextThrow   = TimeUtils.millis();
        start();
    }

    @Override
    protected void start() {
    }

    @Override
    protected void update() {

        //Check if it is time t create a new boomerang
        if (TimeUtils.millis() > nextThrow) {

            //Throw boomerang
            projectileFactory.createBoomerangProjectile(initial);

            //Lower the amount of throws
            amount--;

            //Check if there are any throws left
            if (amount <= 0)

                //Done, destroy the powerup
                powerupList.destroy(this);

            else {

                //Update next throw
                nextThrow = TimeUtils.millis() + duration;
            }
        }
    }
}
