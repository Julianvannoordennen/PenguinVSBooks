package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;

import java.util.ArrayList;
import java.util.Iterator;

public class PickupList implements Renderable {

    private ArrayList<Pickup> pickups;
    private ArrayList<Pickup> disposablePickups;

    public PickupList() {
        pickups = new ArrayList<>();
        disposablePickups = new ArrayList<>();
    }

    public void add(Pickup pickup) {
        pickups.add(pickup);
    }

    public void render(SpriteBatch batch) {
        for(Pickup pickup : pickups)
            pickup.render(batch);
    }

    public ArrayList<Pickup> get() {
        return pickups;
    }

    public void destroy(Pickup pickup) {

        //Place item in special dispose list
        disposablePickups.add(pickup);
    }

    public void dispose() {

        //Check each pickup in the disposable list
        Iterator iterator = disposablePickups.iterator();
        while(iterator.hasNext()) {

            //Get body
            Pickup pickup = (Pickup)iterator.next();
            Body body = pickup.getBody();

            //Destroy fixtures and object
            for(Fixture fixture : body.getFixtureList()) body.destroyFixture(fixture);
            pickups.remove(pickup);
            iterator.remove();
        }
    }
}
