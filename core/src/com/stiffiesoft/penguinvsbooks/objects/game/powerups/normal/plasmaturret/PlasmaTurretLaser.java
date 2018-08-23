package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.plasmaturret;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Projectile;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.rendering.DefinedColors;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class PlasmaTurretLaser implements Projectile, Transformable, GameObject {

    private Transform transform;
    private PlasmaTurretMount mount;
    private ProjectileList projectileList;
    private Color color;

    public PlasmaTurretLaser(Transform transform, GameContext context) {

        //Save values
        this.transform          = transform;
        this.mount              = null;
        this.projectileList     = context.getProjectileList();
        color                   = DefinedColors.POWERUP_RANDOM_COLORS[MathUtils.random(0,DefinedColors.POWERUP_RANDOM_COLORS.length - 1)];
        transform.setSize(new Vector2(C.pW() * 200, C.pW() / 4));
        transform.setCenter(new Vector2(0,transform.getSize().y));
    }

    public void setMount(PlasmaTurretMount mount) {
        this.mount = mount;
        transform.setPosition(new Vector2(transform.getXPosition() + (mount.getTransform().getSize().x / 2),transform.getYPosition() + (mount.getTransform().getSize().y / 2)));
    }

    @Override
    public void update() {

        //Check if mount is not null
        if (this.mount != null) {

            //Look at cursor
            transform.setRotation(this.mount.getTransform().getRotation());

            //Check if the mount is dead
            if (this.mount.isDead())

                //Destroy itself
                projectileList.destroy(this);
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        //Get default color
        Color color = batch.getColor();

        //Change color
        batch.setColor(new Color(this.color.r, this.color.g, this.color.b, 1));

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.screenFader), transform);

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
