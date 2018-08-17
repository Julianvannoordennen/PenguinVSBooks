package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class ProjectileListCleaner {

    private long cleanRate;
    private long next;
    private ProjectileList projectileList;

    public ProjectileListCleaner(GameContext context) {

        //Save list
        this.projectileList = context.getProjectileList();

        //Create fire rate, now the player cannot fire books every tick
        cleanRate = 1000; //Once a second
        updateTime();
    }

    private void updateTime() {
        next = TimeUtils.millis() + cleanRate;
    }

    public void update() {

        //Check if the mouse button is being pressed
        if (TimeUtils.millis() >= next) {

            //Now we have to wait before we can clean again
            updateTime();

            //Check each projectile
            for (Projectile projectile : projectileList.getArray()) {

                //Check if the projectile is not allowed to be outside of the screen
                if (!projectile.outsideAllowed()) {

                    //Get the projectile position
                    Vector2 position = projectile.getTransform().getPosition();

                    //Destroy projectile when outside screen
                    if (C.oS(position)) projectileList.destroy(projectile);
                }
            }
        }
    }
}