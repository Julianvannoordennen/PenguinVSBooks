package com.stiffiesoft.penguinvsbooks.scenes.menu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.effects.MovingFloat;
import com.stiffiesoft.penguinvsbooks.effects.MovingFloatListener;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;
import com.stiffiesoft.penguinvsbooks.gameobjects.menu.MenuButton;
import com.stiffiesoft.penguinvsbooks.system.C;

public class MenuSelectOptionState implements StartMenuState, MovingFloatListener {

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

    public MenuSelectOptionState(StartMenu startMenu) {
        this.startMenu              = startMenu;
        this.screenFader            = startMenu.getMain().getScreenFader();
        this.screenFader.setCurrentIntensity(0.5f);

        float space                 = C.pH() * 10;
        float doubleSpace           = space * 2;
        this.leftButtonsFloat       = new MovingFloat(-space);
        this.rightButtonsFloat      = new MovingFloat(C.sW());

        this.playButton             = new MenuButton("sprites/menu/button_play.png", space, space, this.leftButtonsFloat.getValue(), C.sH() - doubleSpace);
        this.statisticsButton       = new MenuButton("sprites/menu/button_statistics.png", space, space, this.leftButtonsFloat.getValue(), (C.sH() / 2) - (space / 2));
        this.upgradesButton         = new MenuButton("sprites/menu/button_upgrades.png", space, space, this.leftButtonsFloat.getValue(), space);
        this.archievementsButton    = new MenuButton("sprites/menu/button_archievements.png", space, space, this.rightButtonsFloat.getValue(), C.sH() - doubleSpace);
        this.settingsButton         = new MenuButton("sprites/menu/button_settings.png", space, space, this.rightButtonsFloat.getValue(), (C.sH() / 2) - (space / 2));
        this.quitButton             = new MenuButton("sprites/menu/button_quit.png", space, space, this.rightButtonsFloat.getValue(), space);

        this.leftButtonsFloat.move(space, 4f, this);
        this.rightButtonsFloat.move(C.sW() - doubleSpace, 4f, null);
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
    }

    @Override
    public void onDispose() {

    }

    @Override
    public void onFloatMoveDone() {
        System.out.println(1);
    }
}
