package com.stiffiesoft.penguinvsbooks.scenes.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.MovingFloat;
import com.stiffiesoft.penguinvsbooks.effects.MovingFloatListener;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFaderListener;
import com.stiffiesoft.penguinvsbooks.gameobjects.menu.MenuButton;
import com.stiffiesoft.penguinvsbooks.gameobjects.menu.MenuButtonListener;
import com.stiffiesoft.penguinvsbooks.system.C;
import com.stiffiesoft.penguinvsbooks.system.FontFactory;
import com.stiffiesoft.penguinvsbooks.system.S;

public class MenuSelectOptionState implements StartMenuState, MenuButtonListener, MovingFloatListener, ScreenFaderListener {

    private StartMenu startMenu;
    private ScreenFader screenFader;
    private MenuButton playButton;
    private MenuButton settingsButton;
    private MenuButton statisticsButton;
    private MenuButton upgradesButton;
    private MenuButton archievementsButton;
    private MenuButton quitButton;
    private MovingFloat leftButtonsFloat;
    private MovingFloat rightButtonsFloat;
    private MovingFloat fontFloat;
    private FontFactory fontFactory;
    private GlyphLayout fontGlyph;
    private BitmapFont font;
    private int pressedId;

    public MenuSelectOptionState(StartMenu startMenu) {
        this.startMenu              = startMenu;
        this.screenFader            = startMenu.getMain().getScreenFader();
        this.screenFader.setCurrentIntensity(0.5f);

        float space                 = C.pH() * 10;
        float doubleSpace           = space * 2;
        this.leftButtonsFloat       = new MovingFloat(-space);
        this.rightButtonsFloat      = new MovingFloat(C.sW());

        this.pressedId              = 0;
        this.playButton             = new MenuButton(1, "sprites/menu/button_play.png", space, space, this.leftButtonsFloat.getValue(), C.sH() - doubleSpace, null);
        this.statisticsButton       = new MenuButton(2, "sprites/menu/button_statistics.png", space, space, this.leftButtonsFloat.getValue(), (C.sH() / 2) - (space / 2), null);
        this.upgradesButton         = new MenuButton(3, "sprites/menu/button_upgrades.png", space, space, this.leftButtonsFloat.getValue(), space, null);
        this.archievementsButton    = new MenuButton(4, "sprites/menu/button_archievements.png", space, space, this.rightButtonsFloat.getValue(), C.sH() - doubleSpace, null);
        this.settingsButton         = new MenuButton(5, "sprites/menu/button_settings.png", space, space, this.rightButtonsFloat.getValue(), (C.sH() / 2) - (space / 2), null);
        this.quitButton             = new MenuButton(6, "sprites/menu/button_quit.png", space, space, this.rightButtonsFloat.getValue(), space, null);

        this.leftButtonsFloat.move(space, 4f, this);
        this.rightButtonsFloat.move(C.sW() - doubleSpace, 4f, null);

        this.fontFloat              = new MovingFloat(C.pH() * -5);
        this.fontFactory            = startMenu.getMain().getFontFactory();
        this.font                   = this.fontFactory.createNormalFont();
        this.fontGlyph              = this.fontFactory.createGlyph("", font);
    }

    @Override
    public void onShow() {

    }

    @Override
    public void onRender(SpriteBatch batch) {

        leftButtonsFloat.update();
        rightButtonsFloat.update();

        playButton.setX(this.leftButtonsFloat.getValue());
        statisticsButton.setX(this.leftButtonsFloat.getValue());
        upgradesButton.setX(this.leftButtonsFloat.getValue());
        archievementsButton.setX(this.rightButtonsFloat.getValue());
        settingsButton.setX(this.rightButtonsFloat.getValue());
        quitButton.setX(this.rightButtonsFloat.getValue());

        screenFader.draw(batch);
        playButton.draw(batch);
        statisticsButton.draw(batch);
        upgradesButton.draw(batch);
        archievementsButton.draw(batch);
        settingsButton.draw(batch);
        quitButton.draw(batch);

        fontFloat.update();
        font.draw(batch, fontGlyph, 0, fontFloat.getValue());
    }

    @Override
    public void onDispose() {

    }

    @Override
    public void onHoverIn(MenuButton button) {

        //Swap text
        switch (button.getId()) {
            case 1: this.fontGlyph = this.fontFactory.createGlyph(S.startTheGame(),font);               break;
            case 2: this.fontGlyph = this.fontFactory.createGlyph(S.showIngameStatistics(),font);       break;
            case 3: this.fontGlyph = this.fontFactory.createGlyph(S.showIngameUpgrades(),font);         break;
            case 4: this.fontGlyph = this.fontFactory.createGlyph(S.showIngameArchievements(),font);    break;
            case 5: this.fontGlyph = this.fontFactory.createGlyph(S.showConfigurableSettings(),font);   break;
            case 6: this.fontGlyph = this.fontFactory.createGlyph(S.quitTheGame(),font);                break;
        }

        //Move
        fontFloat.move(C.pH() * 25, 5f, null);
    }

    @Override
    public void onHoverOut(MenuButton button) {

        //Move
        fontFloat.move(C.pH() * -5, 5f, null);
    }

    @Override
    public void onPress(MenuButton button) {

        //Remove button listener
        button.setListener(null);

        //Set pressed id
        this.pressedId = button.getId();

        //Move
        fontFloat.move(C.pH() * -5, 5f, null);
        this.leftButtonsFloat.move(-button.getWidth(), 4f, this);
        this.rightButtonsFloat.move(C.sW(), 4f, null);
    }

    @Override
    public void onFloatMoveDone() {

        //Check button
        if (pressedId == 0) {

            //Add listeners
            playButton.setListener(this);
            statisticsButton.setListener(this);
            upgradesButton.setListener(this);
            archievementsButton.setListener(this);
            settingsButton.setListener(this);
            quitButton.setListener(this);

        } else if (pressedId == 6) {

            //Screen fader
            this.screenFader.fade(Color.BLACK, 0.5f, 1, 2f, this);
        }
    }

    @Override
    public void onFadeDone() {

        //Check pressed id
        if (pressedId == 6) {

            //Exit the game
            Gdx.app.exit();
        }
    }
}
