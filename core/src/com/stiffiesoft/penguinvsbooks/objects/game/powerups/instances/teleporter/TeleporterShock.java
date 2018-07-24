package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.effects.SpriteAnimation;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class TeleporterShock implements Projectile, Transformable {

    private Transform transform;
    private ProjectileList projectileList;
    private SpriteAnimation animation;
    private float intensity;
    private float fadeSpeed;

    public TeleporterShock(Transform transform, ProjectileList projectileList) {

        //Save values
        this.transform = transform;
        this.projectileList = projectileList;
        animation = new SpriteAnimation(A.m.get(A.teleporterShock), 30);

        this.intensity = 1;
        this.fadeSpeed = 2;
    }

    @Override
    public void render(SpriteBatch batch) {

        //Get default color
        Color color = batch.getColor();

        //Change color
        this.intensity -= this.fadeSpeed * C.cGT();
        batch.setColor(new Color(color.r, color.g, color.b, this.intensity));

        //Draw projectile sprite
        animation.render(batch, transform);

        //Restore color
        batch.setColor(color);

        //Check if the shock has to fade away
        if (this.intensity <= 0.01f)

            //Destroy shock
            projectileList.destroy(this);
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
}
