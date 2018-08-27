package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.gattlinggunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.input.K;
import com.stiffiesoft.penguinvsbooks.system.input.M;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class GatlingGunnerCursor implements Projectile, Transformable, GameObject {

    private boolean inPlace;
    private Transform transform;
    private SpriteAnimation animation;
    private long inPlaceTime;
    private float scaleDecrease;
    private float scaleAmount;

    public GatlingGunnerCursor(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.inPlace            = false;
        this.animation          = new SpriteAnimation(A.m.get(A.gatlingGunnerCursorStart), 30);
        this.inPlaceTime        = TimeUtils.millis() + 500;
        this.scaleDecrease      = 25;
        this.scaleAmount        = 3;
    }

    public boolean isInPlace() {
        return inPlace;
    }

    @Override
    public void update() {

        //Update position
        Vector2 position = new Vector2(M.p());
        position.add(new Vector2(transform.getWidth() / -2, transform.getHeight() / -2));
        transform.setPosition(position);

        //Check if the part is not in place yet
        if (!inPlace) {

            //Update animation
            animation.update();

            //Check if time is done
            if (TimeUtils.millis() > inPlaceTime) {

                //Part in place
                inPlace = true;
            }
        } else {

            //Need to decrease scale
            if (transform.getXScale() > 1) {

                //Decrease scale
                transform.setScale(new Vector2(
                        transform.getXScale() - (scaleDecrease * C.cGT()),
                        transform.getXScale() - (scaleDecrease * C.cGT())
                ));

            } else {

                //Check if firing
                if (Gdx.input.isButtonPressed(K.attack())) {

                    //Apply increased scale
                    transform.setScale(new Vector2(scaleAmount, scaleAmount));

                } else {

                    //Set default scale
                    transform.setScale(new Vector2(1,1));
                }
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //In place?
        if (inPlace)

            //Draw projectile sprite
            Transform.draw(batch, A.m.get(A.gatlingGunnerCursor), transform);

        else

            //Draw animation
            animation.render(batch, transform);
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public Body getBody() {
        return null;
    }

    @Override
    public boolean doesDamage() {
        return false;
    }

    @Override
    public boolean outsideAllowed() {
        return true;
    }

    @Override
    public int getDepth() {
        return DepthProfiles.PROJECTILES_FOREGROUND - 10;
    }
}
