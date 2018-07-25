package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public abstract class Powerup {

    protected ProjectileFactory projectileFactory;
    protected JunkFactory junkFactory;
    protected PowerupList powerupList;
    protected Transform initial;
    protected Player player;

    public Powerup(GameContext context, Transform initial) {
        this.projectileFactory  = context.getProjectileFactory();
        this.junkFactory        = context.getJunkFactory();
        this.powerupList        = context.getPowerupList();
        this.player             = context.getPlayer();
        this.initial            = initial;
        start();
    }

    protected abstract void start();

    protected abstract void update();
}
