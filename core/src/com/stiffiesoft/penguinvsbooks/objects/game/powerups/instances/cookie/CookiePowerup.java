package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie;

import com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting.EnemyTargetSystem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PowerupList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;

public class CookiePowerup extends Powerup {

    public CookiePowerup(ProjectileFactory projectileFactory, PowerupList powerupList, Transform initial) {
        super(projectileFactory, powerupList, initial);
    }

    @Override
    protected void start() {

        //Create cookie
        CookieProjectile cookieProjectile = projectileFactory.createCookieProjectile(initial);

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {
    }
}
