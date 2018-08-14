package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.megalife;

import com.badlogic.gdx.graphics.Color;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Lifes;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.text.DefinedColors;

public class MegaLifePowerup extends Powerup {

    private Lifes lifes;
    private ScreenFlasher screenFlasher;
    private int increaseAmount;
    private Color flashColor;

    public MegaLifePowerup(GameContext context, Transform initial) {
        super(context, initial);
        increaseAmount      = 2;
        screenFlasher       = context.getScreenFlasher();
        lifes               = context.getLifes();
        flashColor          = DefinedColors.MEGA_LIFE_FLASH;
        start();
    }

    @Override
    protected void start() {

        //Increase lifes
        lifes.apply(increaseAmount);

        //Flash screen
        screenFlasher.flash(flashColor);

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {
    }
}
