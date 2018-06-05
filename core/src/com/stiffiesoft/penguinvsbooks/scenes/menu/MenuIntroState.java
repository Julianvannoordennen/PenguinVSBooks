package com.stiffiesoft.penguinvsbooks.scenes.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.*;
import com.stiffiesoft.penguinvsbooks.system.*;

public class MenuIntroState implements StartMenuState, ScreenFaderListener, MovingFloatListener {

    private StartMenu startMenu;
    private ScreenFader screenFader;
    private GlyphLayout fontGlyph;
    private BitmapFont font;
    private MovingFloat fontFloat;
    private FlashingBool fontBool;
    private boolean spacebarCheck = false;
    private boolean endIntro = false;

    public MenuIntroState(StartMenu startMenu) {
        this.startMenu = startMenu;
        this.screenFader = startMenu.getMain().getScreenFader();

        FontFactory factory = startMenu.getMain().getFontFactory();
        this.font = factory.createNormalFont();
        this.fontGlyph = factory.createGlyph(S.pressSpacebarToContinue(), font);
        this.fontFloat = new MovingFloat(C.pH() * -5);
        this.fontBool = new FlashingBool(true);

        screenFader.fade(Color.BLACK, 1f, 0f, 1f, this);
    }

    @Override
    public void onShow() {
    }

    @Override
    public void onRender(SpriteBatch batch) {
        screenFader.draw(batch);
        fontFloat.update();
        if (this.fontBool.getValue()) font.draw(batch, fontGlyph, 0, fontFloat.getValue());

        //Key check
        if (spacebarCheck && Gdx.input.isKeyJustPressed(62)) {
            spacebarCheck = false;
            endIntro = true;
            fontBool.stop();
            fontFloat.move(C.pH() * -5, 5f, this);
            screenFader.fade(Color.BLACK, 0f, 0.5f, 2f, null);
        }
    }

    @Override
    public void onDispose() {

    }

    @Override
    public void onFadeDone() {
        fontFloat.move(C.pH() * 25, 5f, this);
    }

    @Override
    public void onFloatMoveDone() {
        if (endIntro) {
            startMenu.setState(new MenuSelectOptionState(startMenu));
        } else {
            fontBool.start(500);
            spacebarCheck = true;
        }
    }
}
