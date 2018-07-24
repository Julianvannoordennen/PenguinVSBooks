package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyListListener;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookiePickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade.GrenadePickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser.LaserPickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;

public class PickupFactory implements EnemyListListener {

    private PickupList pickupList;
    private PickupCatalogue pickupCatalogue;
    private BodyFactory bodyFactory;
    private PowerupFactory powerupFactory;
    private int pickupLimit;
    private int spawnChanche;
    private int spawnDelay;
    private long nextSpawn;

    public PickupFactory(BodyFactory bodyFactory, PowerupFactory powerupFactory) {
        this.pickupList = new PickupList();
        this.pickupCatalogue = new PickupCatalogue();

        this.powerupFactory = powerupFactory;
        this.bodyFactory = bodyFactory;

        this.pickupLimit = 5;
        this.spawnChanche = 25;
        this.spawnDelay = 1000; //1 second
        updateTime();
    }

    public PickupList getPickupList() {
        return pickupList;
    }

    private void updateTime() {
        this.nextSpawn = TimeUtils.millis() + spawnDelay;
    }

    public void spawnRandom(Vector2 position) {

        //Get a number between 0 and the maximum spawnchanche
        int random = MathUtils.random(0, pickupCatalogue.getTotalSpawnChanche());

        //Get the item
        pickupCatalogue.getItemBySpawnChanche(random).executeFactoryFunction(this, position);
    }

    @Override
    public void onEnemyDisposed(Enemy enemy) {

        //Get position from enemy
        Vector2 position = enemy.getTransform().getPosition();

        //Check if the factory is going to create a pickup
        if (willSpawn(position)) {

            //Update time
            updateTime();

            //Spawn a random pickup
            spawnRandom(position);
        }
    }

    public boolean willSpawn(Vector2 position) {

        //Check if there is still room for a new powerup
        if (pickupList.get().size() >= this.pickupLimit)
            return false;

        //Check if the time allows it to create a new powerup
        if (TimeUtils.millis() < nextSpawn)
            return false;

        //Check if the position is not outside of the screen
        if (C.oS(position))
            return false;

        //Check if the random integer is correct
        return MathUtils.random(0, spawnChanche) == 0;
    }

    /***** Create Methods *****/
    public GrenadePickup createGrenadePickup(Vector2 position) {

        //Create default transform for pickup
        Transform transform = new Transform(position.x, position.y,C.pH() * 5, C.pH() * 5,1,1,0);

        //Create pickup and apply the transform send in parameter
        GrenadePickup pickup = new GrenadePickup(transform, powerupFactory, pickupList);

        //Add pickup to the list so the program can keep track of it
        pickupList.add(pickup);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Return to projectile
        return pickup;
    }
    public CookiePickup createCookiePickup(Vector2 position) {

        //Create default transform for pickup
        Transform transform = new Transform(position.x, position.y,C.pH() * 5, C.pH() * 5,1,1,0);

        //Create pickup and apply the transform send in parameter
        CookiePickup pickup = new CookiePickup(transform, powerupFactory, pickupList);

        //Add pickup to the list so the program can keep track of it
        pickupList.add(pickup);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Return to projectile
        return pickup;
    }
    public LaserPickup createLaserPickup(Vector2 position) {

        //Create default transform for pickup
        Transform transform = new Transform(position.x, position.y,C.pH() * 5, C.pH() * 5,1,1,0);

        //Create pickup and apply the transform send in parameter
        LaserPickup pickup = new LaserPickup(transform, powerupFactory, pickupList);

        //Add pickup to the list so the program can keep track of it
        pickupList.add(pickup);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Return to projectile
        return pickup;
    }
}
