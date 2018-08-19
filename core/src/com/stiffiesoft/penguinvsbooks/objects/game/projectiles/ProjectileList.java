package com.stiffiesoft.penguinvsbooks.objects.game.projectiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObjectList;

import java.util.ArrayList;
import java.util.Iterator;

public class ProjectileList {

    private GameObjectList gameObjectList;
    private ArrayList<Projectile> queuingProjectiles;
    private ArrayList<Projectile> projectiles;
    private ArrayList<Projectile> disposableProjectiles;

    public ProjectileList(GameContext context) {
        gameObjectList          = context.getGameObjectList();
        queuingProjectiles      = new ArrayList<>();
        projectiles             = new ArrayList<>();
        disposableProjectiles   = new ArrayList<>();
    }

    public void add(Projectile projectile) {
        queuingProjectiles.add(projectile);
        gameObjectList.add((GameObject)projectile);
    }

    public ArrayList<Projectile> getArray() {
        return projectiles;
    }

    public void destroy(Projectile projectile) {

        //Place item in special dispose list
        disposableProjectiles.add(projectile);
    }

    public ArrayList<Projectile> getByClassName(String className) {

        //Keep track of a list which will contain all projectiles from this specific class
        ArrayList<Projectile> projectilesByClass = new ArrayList<>();

        //Go through each projectile to see if it is from the correct class
        for (Projectile projectile : projectiles) {
            if (projectile.getClass().getSimpleName().equals(className))
                projectilesByClass.add(projectile);
        }

        //Return the list
        return projectilesByClass;
    }

    public void dispose() {

        //Check each projectile in the disposable list
        Iterator iterator = disposableProjectiles.iterator();
        while(iterator.hasNext()) {

            //Get body
            Projectile projectile = (Projectile)iterator.next();
            Body body = projectile.getBody();

            //Destroy fixtures and object
            if (body != null) for(Fixture fixture : body.getFixtureList()) body.destroyFixture(fixture);
            projectiles.remove(projectile);
            gameObjectList.remove((GameObject)projectile);
            iterator.remove();
        }

        //Check each projectile in the queue list
        iterator = queuingProjectiles.iterator();
        while(iterator.hasNext()) {

            //Place in normal list
            projectiles.add((Projectile)iterator.next());
            iterator.remove();
        }
    }
}
