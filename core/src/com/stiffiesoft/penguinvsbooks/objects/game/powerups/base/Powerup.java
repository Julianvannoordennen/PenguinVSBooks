package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public abstract class Powerup {

    protected ProjectileFactory projectileFactory;
    protected PowerupList powerupList;
    protected Transform initial;

    public Powerup(ProjectileFactory projectileFactory, PowerupList powerupList, Transform initial) {
        this.projectileFactory = projectileFactory;
        this.powerupList = powerupList;
        this.initial = initial;
        start();
    }

    protected abstract void start();

    protected abstract void update();

}
