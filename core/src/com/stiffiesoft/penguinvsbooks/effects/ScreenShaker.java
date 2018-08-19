package com.stiffiesoft.penguinvsbooks.effects;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class ScreenShaker implements GameObject {

    private float shakeAmount;
    private long time;
    private boolean shake;
    private OrthographicCamera shakeCamera;
    private Vector2 defaultPosition;

    public ScreenShaker() {
        shakeAmount     = C.pH() * 1;
        time            = 0;
        shake           = false;
        shakeCamera     = new OrthographicCamera();
        defaultPosition = new Vector2(C.sW() / 2, C.sH() / 2);
        shakeCamera.setToOrtho(false,C.sW(), C.sH());
        shakeCamera.position.set(defaultPosition.x, defaultPosition.y, 0);
        shakeCamera.update();
    }

    public void shake(long length) {

        //Create temporary time
        long tempTime = TimeUtils.millis() + length;

        //Check if the temporary time will be done before the previous shake
        if (tempTime > time) {

            //Shake
            shake = true;
            time = tempTime;
        }
    }

    @Override
    public void update() {

        //Check if duration is done
        if (TimeUtils.millis() > time && shake) {

            //Disable shake
            shake = false;

            //Restore shake position
            shakeCamera.position.set(
                    defaultPosition.x,
                    defaultPosition.y,
                    0
            );

            //Update the camera
            shakeCamera.update();

        } else if (shake) {

            //Shake
            shakeCamera.position.set(
                    defaultPosition.x + MathUtils.random(-shakeAmount, shakeAmount),
                    defaultPosition.y + MathUtils.random(-shakeAmount, shakeAmount),
                    0
            );

            //Update the camera
            shakeCamera.update();
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //Show the camera
        batch.setProjectionMatrix(shakeCamera.combined);
    }

    @Override
    public int getDepth() {
        return DepthProfiles.INVISIBLE;
    }
}
