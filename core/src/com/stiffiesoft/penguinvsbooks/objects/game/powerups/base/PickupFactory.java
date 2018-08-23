package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyListListener;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bomb.BombPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.bombbook.BombBookPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.boomerang.BoomerangPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.clover.CloverPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookiePickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.dyslexia.DyslexiaPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.earthquake.EarthquakePickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.extralife.ExtraLifePickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.flamethrower.FlameThrowerPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade.GrenadePickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.hacker.HackerPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.katana.KatanaPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser.LaserPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.magnet.MagnetPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.megalife.MegaLifePickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.nuke.NukePickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.plasmaturret.PlasmaTurretPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.saw.SawPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.teleporter.TeleporterPickup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.wizard.WizardPickup;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;

public class PickupFactory implements EnemyListListener {

    private PickupList pickupList;
    private PickupCatalogue pickupCatalogue;
    private BodyFactory bodyFactory;
    private PowerupFactory powerupFactory;
    private ScreenFlasher screenFlasher;
    private GameContext context;
    private int pickupLimit;
    private int spawnChanche;
    private int spawnDelay;
    private long nextSpawn;

    public PickupFactory(GameContext context) {
        this.pickupList         = context.getPickupList();
        this.pickupCatalogue    = context.getPickupCatalogue();
        this.powerupFactory     = context.getPowerupFactory();
        this.bodyFactory        = context.getBodyFactory();
        this.screenFlasher      = context.getScreenFlasher();
        this.context            = context;
        this.pickupLimit        = 5;
        this.spawnChanche       = 25;
        this.spawnDelay         = 1000; //1 second
        updateTime();
    }

    private void updateTime() {
        this.nextSpawn = TimeUtils.millis() + spawnDelay;
    }

    private void spawnRandom(Vector2 position) {

        //Get a number between 0 and the maximum spawnchanche
        int random = MathUtils.random(0, pickupCatalogue.getTotalSpawnChanche());

        //Get the item
        pickupCatalogue.getItemBySpawnChanche(random).executeFactoryFunction(this, position);
    }

    private boolean willSpawn(Vector2 position) {

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

    private Transform beforePickup(Vector2 position) {

        //Return transform
        return new Transform(position.x, position.y,C.pH() * 5, C.pH() * 5,1,1,0);
    }

    private void afterPickup(Pickup pickup) {

        //Add pickup to the list so the program can keep track of it
        pickupList.add(pickup);
    }

    public void forceSpawn(Vector2 position) {

        //Update time
        updateTime();

        //Spawn a random pickup
        spawnRandom(position);
    }

    @Override
    public void onEnemyDisposed(Enemy enemy) {

        //Get position from enemy
        Vector2 position = enemy.getTransform().getPosition();

        //Check if the factory is going to create a pickup
        if (willSpawn(position)) forceSpawn(position);
    }

    /***** Create Methods *****/
    public Pickup createGrenadePickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new GrenadePickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createCookiePickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new CookiePickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createLaserPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new LaserPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createTeleporterPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new TeleporterPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createMagnetPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new MagnetPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createBombPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new BombPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createKatanaPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new KatanaPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createExtraLifePickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new ExtraLifePickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createMegaLifePickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new MegaLifePickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createEarthquakePickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new EarthquakePickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createNukePickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new NukePickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createBoomerangPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new BoomerangPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createPlasmaTurretPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new PlasmaTurretPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createHackerPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new HackerPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createDyslexiaPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new DyslexiaPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createFlameThrowerPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new FlameThrowerPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createSawPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new SawPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createWizardPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new WizardPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createCloverPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new CloverPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
    public Pickup createBombBookPickup(Vector2 position) {

        //Create pickup and apply the transform send in parameter
        Pickup pickup = new BombBookPickup(beforePickup(position), context);

        //Add bodytask for the projectile
        bodyFactory.addTask(new PickupBodyTask(pickup));

        //Execute default tasks
        afterPickup(pickup);

        //Return to projectile
        return pickup;
    }
}
