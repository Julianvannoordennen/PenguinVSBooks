package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.effects.ScreenShaker;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;
import com.stiffiesoft.penguinvsbooks.system.rendering.DefinedColors;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class ShredderCannonPart implements Projectile, Transformable, GameObject {

    private boolean inPlace;
    private Transform transform;
    private ScreenFlasher screenFlasher;
    private ScreenShaker screenShaker;
    private Texture part;
    private Vector2 center;
    private long shakeLength;
    private float movementSpeed;

    public ShredderCannonPart(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.inPlace            = false;
        this.center             = new Vector2(C.sW() / 2, C.sH() / 2);
        this.movementSpeed      = C.pH() * 200;
        this.screenFlasher      = context.getScreenFlasher();
        this.screenShaker       = context.getScreenShaker();
        this.shakeLength        = 250;
        setPartPiece(1);
    }

    public void setPartPiece(int partPiece) {

        //Check which number has been sended
        switch (partPiece) {
            case 1:
                part = A.m.get(A.shredderCannonPart1);
                break;
            case 2:
                part = A.m.get(A.shredderCannonPart2);
                break;
            case 3:
                part = A.m.get(A.shredderCannonPart3);
                break;
            case 4:
                part = A.m.get(A.shredderCannonPart4);
                break;
        }
    }

    public boolean isInPlace() {
        return inPlace;
    }

    @Override
    public void update() {

        //Check if the part is not in place yet
        if (!inPlace) {

            //Move towards the center
            transform.setMovementAngle(C.getAngleInRadians(transform.getPositionCenter(), center));
            transform.moveInDirection(this.movementSpeed * C.cGT());

            //Check if we are in the center
            if (transform.getPositionCenter().dst(center) < C.pH() * 5) {

                //Apply default position
                transform.setPosition(center);
                transform.applyPosition(new Vector2(-transform.getXCenter(), -transform.getYCenter()));

                //Create effects
                screenFlasher.flash(DefinedColors.MEGA_POWERUP_FLASH);
                screenShaker.shake(shakeLength);

                //Part in place
                inPlace = true;
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //Draw projectile sprite
        Transform.draw(batch, part, transform);
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
        return DepthProfiles.PROJECTILES_BACKGROUND;
    }
}
