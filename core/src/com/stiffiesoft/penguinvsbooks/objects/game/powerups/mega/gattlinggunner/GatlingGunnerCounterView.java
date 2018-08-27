package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.gattlinggunner;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.effects.ScreenShaker;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.rendering.DefinedColors;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

import java.awt.*;

public class GatlingGunnerCounterView implements Projectile, Transformable, GameObject {

    private boolean inPlace;
    private Transform transform;
    private Vector2 target;
    private float movementSpeed;
    private int value;
    private BitmapFont font;

    public GatlingGunnerCounterView(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.inPlace            = false;
        this.target             = new Vector2(C.sW() / 2, 0);
        this.movementSpeed      = C.pH() * 100;
        this.font               = context.getFontFactory().createNormalFont();
        this.value              = 0;
    }

    public boolean isInPlace() {
        return inPlace;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void update() {

        //Check if the part is not in place yet
        if (!inPlace) {

            //Move towards the center
            transform.setMovementAngle(C.getAngleInRadians(transform.getPositionCenter(), target));
            transform.moveInDirection(this.movementSpeed * C.cGT());

            //Check if we are in the center
            if (transform.getPositionCenter().dst(target) < C.pH()) {

                //Apply default position
                transform.setPosition(target);
                transform.applyPosition(new Vector2(-transform.getXCenter(), -transform.getYCenter()));

                //Part in place
                inPlace = true;
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.gatlingGunnerCounterView), transform);
        if (inPlace)
            font.draw(batch, value + "", 0, C.pH() * 10, C.sW(),1, true);
    }


    public void dispose() {

        //Dispose
        font.dispose();
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
        return DepthProfiles.PROJECTILES_FOREGROUND;
    }
}
