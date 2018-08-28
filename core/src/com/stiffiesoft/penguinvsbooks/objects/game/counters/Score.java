package com.stiffiesoft.penguinvsbooks.objects.game.counters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyListListener;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.text.FontFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class Score extends Counter implements EnemyListListener {

    private int increment;
    private int multiplier;

    public Score(GameContext context) {
        super(context);

        //Set score values
        multiplier          = 1;
        increment           = 10;
        font                = fontFactory.createFont();
        max                 = 666666; //Highscore here
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Define multiplier string
        String multiplier = this.multiplier > 1 ? "x" + this.multiplier : "";

        //Draw the text including the score
        float scale = font.getData().scaleX;
        font.getData().setScale(scale * 2);
        font.draw(batch, fontFactory.createScoreGlyph(S.score() + " " + multiplier + "\n" + value + " \\ " + max,this.font), (C.sW() / 2) - (C.pW() * 10), (C.sH() - (C.pW() * 2)) + shakeCurrent);
        font.getData().setScale(scale);
    }

    @Override
    public void onEnemyDisposed(Enemy enemy) {

        //Add score
        apply(increment * multiplier);
    }
}
