package com.stiffiesoft.penguinvsbooks.objects.game.notifications;

import com.badlogic.gdx.Gdx;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.input.K;

public class PauseChecker {

    private boolean canPause;
    private NotificationFactory notificationFactory;
    private PauseWindow pauseWindow;

    public PauseChecker(GameContext context) {
        this.canPause               = true;
        this.notificationFactory    = context.getNotificationFactory();
        this.pauseWindow            = context.getPauseWindow();
    }

    public void update() {

        //Check if we can pause
        if (canPause) {

            //Check if pause button is pressed
            if (Gdx.input.isKeyPressed(K.pause())) {

                //Now we cant pause the game anymore
                canPause = false;

                //Set gamespeed to 0
                C.gT(0);

                //Create the pause notification using the notificationfactory
                notificationFactory.createPauseNotification();
                notificationFactory.createPauseNotification();
                notificationFactory.createPauseNotification();

                //Show all current notifications
                pauseWindow.showNotification();
            }
        }
    }

    public boolean canPause() {
        return canPause;
    }

    public void canPause(boolean canPause) {

        //Can we pause again?
        if (canPause)
            C.gT(1);

        this.canPause = canPause;
    }
}
