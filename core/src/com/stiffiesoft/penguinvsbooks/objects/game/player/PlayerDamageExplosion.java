package com.stiffiesoft.penguinvsbooks.objects.game.player;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Explosion;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class PlayerDamageExplosion extends Explosion {

    private Color color;

    public PlayerDamageExplosion(Transform transform, ProjectileList projectileList) {
        super(transform, projectileList);
        color = new Color(1f,0.1f,0.1f,1);
    }

    @Override
    public void render(SpriteBatch batch) {

        //Decrease size
        Vector2 newScale = new Vector2(transform.getXScale() - (decreaseSpeed * C.cGT()), transform.getYScale() - (decreaseSpeed * C.cGT()));
        transform.setScale(newScale);

        //Rotate
        transform.rotate(rotationSpeed * C.cGT());

        //Get default color
        Color color = batch.getColor();

        //Change color
        batch.setColor(new Color(this.color.r, this.color.g, this.color.b, this.color.a));

        //Draw explosion
        Transform.draw(batch, A.m.get(A.explosion), transform);

        //Restore color
        batch.setColor(color);

        //Check scale
        checkScale();
    }
}
