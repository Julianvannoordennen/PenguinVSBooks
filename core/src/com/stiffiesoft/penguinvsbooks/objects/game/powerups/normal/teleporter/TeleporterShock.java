package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.teleporter;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class TeleporterShock implements Projectile, Transformable, GameObject {

    private Transform transform;
    private ProjectileList projectileList;
    private SpriteAnimation animation;
    private float intensity;
    private float fadeSpeed;

    public TeleporterShock(Transform transform, GameContext context) {

        //Save values
        this.transform      = transform;
        this.projectileList = context.getProjectileList();
        this.animation      = new SpriteAnimation(A.m.get(A.teleporterShock), 30);

        this.intensity      = 1;
        this.fadeSpeed      = 2;
    }

    @Override
    public void update() {

        //Change intensity
        this.intensity -= this.fadeSpeed * C.cGT();

        //Check if the shock has to fade away
        if (this.intensity <= 0.01f)

            //Destroy shock
            projectileList.destroy(this);

        //Update animation
        animation.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Get default color
        Color color = batch.getColor();

        //Change color
        batch.setColor(new Color(color.r, color.g, color.b, this.intensity));

        //Draw projectile sprite
        animation.render(batch, transform);

        //Restore color
        batch.setColor(color);
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
