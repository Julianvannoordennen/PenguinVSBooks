package com.stiffiesoft.penguinvsbooks.scenes.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.effects.Border;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Lifes;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Score;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkList;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupList;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PowerupFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PowerupList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileListCleaner;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.DynamicRenderingList;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;
import com.stiffiesoft.penguinvsbooks.system.collision.CollisionDetector;
import com.stiffiesoft.penguinvsbooks.system.text.FontFactory;

public class GameContext {

    //Main
    private Main main;

    //Collision instances
    private World world;

    //Effects
    private Border border;
    private ScreenFlasher screenFlasher;

    //Lists
    private DynamicRenderingList renderList;
    private EnemyList enemyList;
    private JunkList junkList;
    private PickupList pickupList;
    private PowerupList powerupList;
    private ProjectileList projectileList;

    //Factories
    private PickupFactory pickupFactory;
    private PowerupFactory powerupFactory;
    private BodyFactory bodyFactory;
    private EnemyFactory enemyFactory;
    private ProjectileFactory projectileFactory;
    private JunkFactory junkFactory;
    private FontFactory fontFactory;

    //Counters
    private Score score;
    private Lifes lifes;

    //Other
    private ProjectileListCleaner projectileListCleaner;
    private Player player;

    public GameContext(Main main) {
        load(main);
    }

    private void load(Main main) {

        //Save the main
        this.main                       = main;

        //Load collision system
        this.world                      = new World(new Vector2(0,0),true);
        this.world.setContactListener(new CollisionDetector());

        //Load effects
        this.border                     = new Border();
        this.screenFlasher              = new ScreenFlasher();

        //Create all lists
        this.renderList                 = new DynamicRenderingList();
        this.enemyList                  = new EnemyList();
        this.junkList                   = new JunkList();
        this.powerupList                = new PowerupList();
        this.pickupList                 = new PickupList();
        this.projectileList             = new ProjectileList();

        //Create all factories that will be used inside the game
        this.junkFactory                = new JunkFactory();
        this.bodyFactory                = new BodyFactory(world);
        this.enemyFactory               = new EnemyFactory(bodyFactory, junkFactory);
        this.projectileFactory          = new ProjectileFactory(bodyFactory, screenFlasher);
        this.powerupFactory             = new PowerupFactory(projectileFactory);
        this.pickupFactory              = new PickupFactory(bodyFactory, powerupFactory, screenFlasher);
        this.fontFactory                = main.getFontFactory();

        //Create all counters
        this.score                      = new Score(fontFactory);
        this.lifes                      = new Lifes(fontFactory);

        //Create other instances
        this.projectileListCleaner      = new ProjectileListCleaner(projectileFactory.getProjectileList());
        this.player                     = new Player(this, projectileFactory);

        //Connect
        connect();
    }

    private void connect() {

        //Add all items that need to be rendered, in order from background to foreground
        renderList.add(junkList);
        renderList.add(pickupList);
        renderList.add(player);
        renderList.add(enemyList);
        renderList.add(projectileList);
        renderList.add(score);
        renderList.add(lifes);
        renderList.add(border);
        renderList.add(screenFlasher);

        //Add all connections
        bodyFactory.addTask(new PlayerBodyTask(player));
        enemyFactory.getEnemyList().addListener(score);
        enemyFactory.getEnemyList().addListener(pickupFactory);
        player.addListener(lifes);
    }

    public Main getMain() {
        return main;
    }

    public World getWorld() {
        return world;
    }

    public Border getBorder() {
        return border;
    }

    public ScreenFlasher getScreenFlasher() {
        return screenFlasher;
    }

    public DynamicRenderingList getRenderList() {
        return renderList;
    }

    public PickupFactory getPickupFactory() {
        return pickupFactory;
    }

    public PowerupFactory getPowerupFactory() {
        return powerupFactory;
    }

    public BodyFactory getBodyFactory() {
        return bodyFactory;
    }

    public EnemyFactory getEnemyFactory() {
        return enemyFactory;
    }

    public ProjectileFactory getProjectileFactory() {
        return projectileFactory;
    }

    public JunkFactory getJunkFactory() {
        return junkFactory;
    }

    public FontFactory getFontFactory() {
        return fontFactory;
    }

    public Score getScore() {
        return score;
    }

    public Lifes getLifes() {
        return lifes;
    }

    public ProjectileListCleaner getProjectileListCleaner() {
        return projectileListCleaner;
    }

    public Player getPlayer() {
        return player;
    }

    public EnemyList getEnemyList() {
        return enemyList;
    }

    public JunkList getJunkList() {
        return junkList;
    }

    public PickupList getPickupList() {
        return pickupList;
    }

    public PowerupList getPowerupList() {
        return powerupList;
    }

    public ProjectileList getProjectileList() {
        return projectileList;
    }
}
