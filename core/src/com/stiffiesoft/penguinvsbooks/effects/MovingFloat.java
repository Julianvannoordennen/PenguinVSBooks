package com.stiffiesoft.penguinvsbooks.effects;

import com.stiffiesoft.penguinvsbooks.system.C;

public class MovingFloat {

    private float speed;
    private float end;
    private float value;
    private boolean increase;
    private boolean active;
    private MovingFloatListener listener;

    public MovingFloat(float defaultValue) {
        reset();
        value = defaultValue;
    }

    public void reset() {
        speed = 0;
        end = 0;
        value = 0;
        increase = false;
        active = false;
    }

    public void move(float start, float end, float speed, MovingFloatListener listener) {

        //Increase or decrease?
        this.increase = start <= end;
        this.value = start;
        this.end = end;
        this.speed = speed;
        this.active = true;
        this.listener = listener;
    }

    public void move(float end, float speed, MovingFloatListener listener) {

        //Call default
        move(this.value, end, speed, listener);
    }

    public void update() {

        //Check if active
        if (active) {

            //Add to value
            value += (increase ? speed : -speed) * C.eT();

            //Check if out of range
            if ((this.value >= this.end && this.increase) || (this.value <= this.end && !this.increase)) {

                //Not active
                active = false;

                //Listener
                if (listener != null) listener.onFloatMoveDone();
            }
        }
    }

    public float getValue() {
        return this.value;
    }
}
