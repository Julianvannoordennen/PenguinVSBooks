package com.stiffiesoft.penguinvsbooks.objects.game.counters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyListListener;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.text.FontFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class Score extends Counter implements EnemyListListener {

    private int defaultIncrement;
    private int increment;

    public Score(FontFactory fontFactory) {
        super(fontFactory);

        //Set score values
        defaultIncrement = 10;
        increment = defaultIncrement;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Return shake
        returnShake();

        //Draw the text including the score
        font.draw(batch, fontFactory.createCounterGlyph(S.score() + "\n" + value,this.font), C.pW() * 2, (C.sH() - (C.pW() * 2)) + shakeCurrent);
    }

    @Override
    public void onEnemyDisposed(Enemy enemy) {

        //Add score
        apply(increment);
    }
}
