package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import java.util.ArrayList;
import java.util.Iterator;

//POWERUPS MAY NOT BE RENDERABLE, A POWERUP IS THE PROCESS THAT WILL CREATE AND DESTROY PROJECTILES
public class PowerupList {

    private ArrayList<Powerup> powerups;
    private ArrayList<Powerup> disposablePowerups;

    public PowerupList() {
        powerups = new ArrayList<>();
        disposablePowerups = new ArrayList<>();
    }

    public void add(Powerup powerup) {
        powerups.add(powerup);
    }

    public ArrayList<Powerup> get() {
        return powerups;
    }

    public void destroy(Powerup powerup) {

        //Place item in special dispose list
        disposablePowerups.add(powerup);
    }

    public void update() {

        //Update each powerup
        for(Powerup powerup : powerups)
            powerup.update();
    }

    public void dispose() {

        //Check each powerup in the disposable list
        Iterator iterator = disposablePowerups.iterator();
        while(iterator.hasNext()) {

            //Get powerup
            Powerup powerup = (Powerup)iterator.next();

            //Destroy object
            powerups.remove(powerup);
            iterator.remove();
        }
    }
}
