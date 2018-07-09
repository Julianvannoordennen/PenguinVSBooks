package com.stiffiesoft.penguinvsbooks.objects.game.enemies.counters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.text.FontFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class Score extends Counter {

    public Score(FontFactory fontFactory) {
        super(fontFactory);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw the text including the score
        font.draw(batch, fontFactory.createCounterGlyph(S.score() + "\n" + value,this.font), C.pW() * 2, C.sH() - (C.pW() * 2));
    }
}
