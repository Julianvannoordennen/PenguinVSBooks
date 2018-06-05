package com.stiffiesoft.penguinvsbooks.effects;

import java.util.Timer;
import java.util.TimerTask;

public class FlashingBool extends TimerTask {

    private boolean value;
    private Timer timer;

    public FlashingBool(boolean value) {
        this.value = value;
        this.timer = new Timer();
    }

    public void start(int interval) {
        start(interval, value);
    }

    public void start(int interval, boolean value) {
        this.value = value;
        timer.schedule(this, interval, interval);
    }

    public void stop() {
        timer.cancel();
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public void run() {
        value = !value;
    }
}
