package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.gattlinggunner;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Counter;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class GatlingGunnerCounter extends Counter {

    public GatlingGunnerCounter(GameContext context) {
        super(context);
        max = 600;
    }

    @Override
    public void render(SpriteBatch batch) {

        GlyphLayout glyph = fontFactory.createCounterGlyph(S.ammo() + "\n" + value + " \\ " + max,this.font);
        font.draw(batch, glyph , C.sW() - (C.pW() * 20), ((C.pW() * 2) + glyph.height) + shakeCurrent);
    }
}
