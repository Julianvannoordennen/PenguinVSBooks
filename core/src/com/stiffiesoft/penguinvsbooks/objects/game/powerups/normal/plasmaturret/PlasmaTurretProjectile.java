package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.plasmaturret;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.LinearProjectile;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.Collidable;

public class PlasmaTurretProjectile extends LinearProjectile {

    public PlasmaTurretProjectile(Transform transform, GameContext context) {

        //Use the default settings from the projectile
        super(transform, context);
        speed               = C.pH() * 200;
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
        batch.setColor(new Color(color.r, color.g, color.b, 0.1f));

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.plasmaTurretProjectile), glowTransform);

        //Restore color
        batch.setColor(color);

        //Draw projectile sprite
        Transform.draw(batch, A.m.get(A.plasmaTurretProjectile), transform);
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
