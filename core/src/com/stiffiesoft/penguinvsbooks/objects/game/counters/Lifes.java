package com.stiffiesoft.penguinvsbooks.objects.game.counters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerListener;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.text.FontFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class Lifes extends Counter implements PlayerListener {

    public Lifes(FontFactory fontFactory) {
        super(fontFactory);
        value = 43242;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Return shake
        returnShake();

        //Draw the text including the lifes
        font.draw(batch, fontFactory.createCounterGlyph(S.lifes() + "\n" + value,this.font), C.sW() - (C.pW() * 12), (C.sH() - (C.pW() * 2)) + shakeCurrent);
    }

    @Override
    public void onPlayerDamage(Player player) {

        //Decrease lifes
        value--;

        //Check if it's time to die
        if (value == 0) player.die();
    }
}
