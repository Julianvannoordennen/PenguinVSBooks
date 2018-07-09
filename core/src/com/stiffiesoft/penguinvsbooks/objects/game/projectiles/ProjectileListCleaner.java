package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

import java.util.Iterator;

public class ProjectileListCleaner {

    private long cleanRate;
    private long next;
    private ProjectileList projectileList;

    public ProjectileListCleaner(ProjectileList projectileList) {

        //Save list
        this.projectileList = projectileList;

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
            Iterator iterator = projectileList.get().iterator();
            while(iterator.hasNext()) {

                //Get the projectile for the iterator
                Projectile projectile = (Projectile)iterator.next();

                //Get the projectile position
                Vector2 position = projectile.getTransform().getPosition();

                //Destroy projectile when outside screen
                if (C.oS(position)) iterator.remove();
            }
        }
    }
}
