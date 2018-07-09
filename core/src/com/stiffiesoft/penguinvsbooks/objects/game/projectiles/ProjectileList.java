package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

import java.util.ArrayList;
import java.util.Iterator;

public class ProjectileList implements Renderable {

    private ArrayList<Projectile> projectiles;
    private ArrayList<Projectile> disposableProjectiles;

    public ProjectileList() {
        projectiles             = new ArrayList<>();
        disposableProjectiles   = new ArrayList<>();
    }

    public void add(Projectile projectile) {
        projectiles.add(projectile);
    }

    public void render(SpriteBatch batch) {
        for(Projectile projectile : projectiles)
            projectile.render(batch);
    }

    public ArrayList<Projectile> get() {
        return projectiles;
    }

    public void destroy(Projectile projectile) {

        //Place item in special dispose list
        disposableProjectiles.add(projectile);

        //Remove from first list
        projectiles.remove(projectile);
    }

    public void dispose() {

        //Check each projectile in the disposable list
        Iterator iterator = disposableProjectiles.iterator();
        while(iterator.hasNext()) {

            //Get body
            Projectile projectile = (Projectile)iterator.next();
            Body body = projectile.getBody();

            //Destroy fixtures and object
            for(Fixture fixture : body.getFixtureList()) body.destroyFixture(fixture);
            iterator.remove();
        }
    }
}
