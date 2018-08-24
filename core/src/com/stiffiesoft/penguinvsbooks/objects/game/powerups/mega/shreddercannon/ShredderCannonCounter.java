package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Counter;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyListListener;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class ShredderCannonCounter extends Counter {

    public ShredderCannonCounter(GameContext context) {
        super(context);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw the text including the score
        font.draw(batch, fontFactory.createCounterGlyph(S.blueprints() + "\n" + value,this.font), C.pW() * 2, (C.pW() * 6) + shakeCurrent);
    }
}
