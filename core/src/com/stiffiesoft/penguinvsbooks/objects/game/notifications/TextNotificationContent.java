package com.stiffiesoft.penguinvsbooks.objects.game.notifications;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.input.K;
import com.stiffiesoft.penguinvsbooks.system.text.FontFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public abstract class TextNotificationContent extends NotificationContent {

    protected String content;
    protected GlyphLayout fontGlyph;
    protected BitmapFont font;

    public TextNotificationContent(String content, GameContext context) {
        super();

        FontFactory factory = context.getFontFactory();
        this.font           = factory.createSmallFont();
        this.fontGlyph      = factory.createNotificationGlyph(content, font);
        this.content        = content;
    }

    public String getContent() {
        return content;
    }

    private void checkClick() {

        //Check if the fire button has been pressed
        if (Gdx.input.isButtonPressed(K.attack())) {

            //Content done
            ready   = false;
            done    = true;
            font.dispose();
        }
    }

    @Override
    protected void render(SpriteBatch batch, Vector2 position) {

        //Render text
        font.draw(batch, fontGlyph, position.x + (C.pW() * 1.5f), position.y + C.pH() * 30);

        //Check if the message has already been clicked away
        checkClick();
    }
}
