package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter;

import com.badlogic.gdx.graphics.Color;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.Explosion;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class TeleporterExplosion extends Explosion {

    public TeleporterExplosion(Transform transform, ProjectileList projectileList) {
        super(transform, projectileList);

        //Change explosion color
        color = new Color(0.1f,0.1f,0.75f,1);
        this.decreaseSpeed = 10f;
    }
}
