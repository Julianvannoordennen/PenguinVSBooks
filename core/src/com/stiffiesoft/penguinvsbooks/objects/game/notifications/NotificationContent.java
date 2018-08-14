package com.stiffiesoft.penguinvsbooks.objects.game.notifications;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Pickup;

import java.util.ArrayList;
import java.util.Iterator;

/*


NOTIFICATION COUNTER LEFTTOP
SCORE TOPCENTER
WHEN PRESSING ESCAPE ALL NOTIFICATIONS WILL BE SHOWN


 */

public abstract class NotificationContent {

    protected abstract void render(SpriteBatch batch, Vector2 position);

    protected boolean ready;
    protected boolean done;

    public NotificationContent() {
        this.ready  = false;
        this.done   = false;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
