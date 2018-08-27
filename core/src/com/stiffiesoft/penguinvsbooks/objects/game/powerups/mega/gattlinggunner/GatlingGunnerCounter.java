package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.gattlinggunner;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Counter;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class GatlingGunnerCounter extends Counter {

    public GatlingGunnerCounter(GameContext context) {
        super(context);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw the text including the score
        font.draw(batch, fontFactory.createCounterGlyph(S.ammo() + "\n" + value,this.font), C.sW() - (C.pW() * 10), (C.pW() * 8) + shakeCurrent);
    }
}
