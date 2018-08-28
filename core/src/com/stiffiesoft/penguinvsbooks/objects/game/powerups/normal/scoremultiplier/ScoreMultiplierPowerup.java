package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.scoremultiplier;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Lifes;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Score;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.rendering.DefinedColors;

public class ScoreMultiplierPowerup extends Powerup {

    private int increaseAmount;
    private Score score;
    private long next;

    public ScoreMultiplierPowerup(GameContext context, Transform initial) {
        super(context, initial);
        increaseAmount      = 1;
        score               = context.getScore();
        next                = TimeUtils.millis() + 10000; //10 seconds
        start();
    }

    @Override
    protected void start() {

        //Increase lifes
        score.setMultiplier(score.getMultiplier() + increaseAmount);
    }

    @Override
    protected void update() {

        //Time done?
        if (TimeUtils.millis() > next) {

            //Decrease lifes
            score.setMultiplier(score.getMultiplier() - increaseAmount);

            //Done, destroy the powerup
            powerupList.destroy(this);
        }
    }
}
