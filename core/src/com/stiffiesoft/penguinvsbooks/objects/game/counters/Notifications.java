package com.stiffiesoft.penguinvsbooks.objects.game.counters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class Notifications extends Counter {

    public Notifications(GameContext context) {
        super(context);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw the text including the score
        font.draw(batch, fontFactory.createCounterGlyph(S.notifications() + "\n" + value,this.font), 0, (C.sH() - (C.pW() * 2)) + shakeCurrent);
    }
}

