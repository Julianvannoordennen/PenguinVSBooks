package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.wizard;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public class WizardProjectile  extends LinearProjectile {

    private Texture drawable;

    public WizardProjectile(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);
        speed               = C.pH() * 75;

        Texture[] s = {
                A.m.get(A.wizardProjectile1),
                A.m.get(A.wizardProjectile2),
                A.m.get(A.wizardProjectile3),
                A.m.get(A.wizardProjectile4),
                A.m.get(A.wizardProjectile5),
                A.m.get(A.wizardProjectile6),
                A.m.get(A.wizardProjectile7),
                A.m.get(A.wizardProjectile8)
        };

        drawable = s[MathUtils.random(0,s.length - 1)];
    }

    @Override
    public void update() {

        //Move in correct direction
        super.update();
    }

    @Override
    public void render(SpriteBatch batch) {

        //Set glow transform size
        Transform glowTransform = transform.clone();
        glowTransform.setScale(new Vector2(10,10));

        //Get default color
        Color color = batch.getColor();

        //Change color
        batch.setColor(new Color(0.15f, 1, 1, 0.2f));

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.plasmaTurretProjectile), glowTransform);

        //Restore color
        batch.setColor(color);

        //Draw projectile sprite
        Transform.draw(batch, drawable, transform);
    }

    @Override
    public void onCollisionEnter(Collidable other, short collisionType) {

        //Create junk
        junkFactory.createPlasmaTurretProjectileJunk(transform.clone());

        //Destroy self
        projectileList.destroy(this);
    }

    @Override
    public boolean outsideAllowed() {
        return false;
    }
}
