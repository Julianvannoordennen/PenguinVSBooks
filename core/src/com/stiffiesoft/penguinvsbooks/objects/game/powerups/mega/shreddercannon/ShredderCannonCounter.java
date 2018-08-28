package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Counter;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class ShredderCannonCounter extends Counter {

    public ShredderCannonCounter(GameContext context) {
        super(context);
        max = 10;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw the text including the score
        GlyphLayout glyph = fontFactory.createCounterGlyph(S.blueprints() + "\n" + value + " \\ " + max,this.font);
        font.draw(batch, glyph , 0, ((C.pW() * 2) + glyph.height) + shakeCurrent);
    }
}
