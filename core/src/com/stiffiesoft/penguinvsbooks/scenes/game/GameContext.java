package com.stiffiesoft.penguinvsbooks.scenes.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.Main;
import com.stiffiesoft.penguinvsbooks.effects.Border;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFlasher;
import com.stiffiesoft.penguinvsbooks.effects.ScreenShaker;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Lifes;
import com.stiffiesoft.penguinvsbooks.objects.game.counters.Score;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.junk.JunkList;
import com.stiffiesoft.penguinvsbooks.objects.game.notifications.NotificationFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.notifications.NotificationList;
import com.stiffiesoft.penguinvsbooks.objects.game.notifications.PauseChecker;
import com.stiffiesoft.penguinvsbooks.objects.game.notifications.PauseWindow;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.player.PlayerBodyTask;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.*;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.gattlinggunner.GatlingGunnerCounter;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon.ShredderCannonCounter;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileListCleaner;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObjectList;
import com.stiffiesoft.penguinvsbooks.system.collision.BodyFactory;
import com.stiffiesoft.penguinvsbooks.system.collision.CollisionDetector;
import com.stiffiesoft.penguinvsbooks.system.text.FontFactory;

public class GameContext {

    //Main
    private Main main;

    //Collision normal
    private World world;

    //Effects
    private ScreenShaker screenShaker;
    private Border border;
    private ScreenFlasher screenFlasher;
    private ScreenFader screenFader;

    //Lists
    private NotificationList notificationList;
    private GameObjectList gameObjectList;
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
    private NotificationFactory notificationFactory;

    //Counters
    private Score score;
    private Lifes lifes;
    private ShredderCannonCounter shredderCannonCounter;
    private GatlingGunnerCounter gatlingGunnerCounter;

    //Pause
    private PauseWindow pauseWindow;
    private PauseChecker pauseChecker;

    //Other
    private ProjectileListCleaner projectileListCleaner;
    private Player player;
    private PickupCatalogue pickupCatalogue;

    public GameContext(Main main) {
        load(main);
    }

    private void load(Main main) {

        /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

             ! WARNING ! - Do not edit the order of this list to prevent NULL issues - ! WARNING !

         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        //Create priority normal
        this.main                       = main;
        this.world                      = new World(new Vector2(0,0),true);
        this.pickupCatalogue            = main.getPickupCatalogue();

        //Load effects
        this.screenShaker               = new ScreenShaker();
        this.border                     = new Border();
        this.screenFlasher              = new ScreenFlasher();
        this.screenFader                = new ScreenFader();

        //Create all lists
        this.notificationList           = new NotificationList();
        this.gameObjectList             = new GameObjectList();
        this.enemyList                  = new EnemyList(this);
        this.junkList                   = new JunkList(this);
        this.powerupList                = new PowerupList();
        this.pickupList                 = new PickupList(this);
        this.projectileList             = new ProjectileList(this);
        this.projectileListCleaner      = new ProjectileListCleaner(this);

        //Create all factories that will be used inside the game
        this.fontFactory                = main.getFontFactory();
        this.junkFactory                = new JunkFactory(this);
        this.bodyFactory                = new BodyFactory(this);
        this.enemyFactory               = new EnemyFactory(this);
        this.projectileFactory          = new ProjectileFactory(this);
        this.powerupFactory             = new PowerupFactory(this);
        this.pickupFactory              = new PickupFactory(this);
        this.notificationFactory        = new NotificationFactory(this);

        //Create player
        this.player                     = new Player(this);

        //Create pause items
        this.pauseWindow                = new PauseWindow(this);
        this.pauseChecker               = new PauseChecker(this);

        //Create all counters
        this.score                      = new Score(this);
        this.lifes                      = new Lifes(this);
        this.shredderCannonCounter      = new ShredderCannonCounter(this);
        this.gatlingGunnerCounter       = new GatlingGunnerCounter(this);

        //Connect
        connect();
    }

    private void connect() {

        //Add all items that need to be rendered, in order from background to foreground
        gameObjectList.add(player);
        gameObjectList.add(score);
        gameObjectList.add(lifes);
        gameObjectList.add(shredderCannonCounter);
        gameObjectList.add(gatlingGunnerCounter);
        gameObjectList.add(border);
        gameObjectList.add(screenShaker);
        gameObjectList.add(screenFlasher);
        gameObjectList.add(screenFader);

        //Add all connections
        world.setContactListener(new CollisionDetector());
        bodyFactory.addTask(new PlayerBodyTask(player));
        enemyList.addListener(score);
        enemyList.addListener(pickupFactory);
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

    public ScreenShaker getScreenShaker() {
        return screenShaker;
    }

    public GameObjectList getGameObjectList() {
        return gameObjectList;
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

    public PickupCatalogue getPickupCatalogue() {
        return pickupCatalogue;
    }

    public NotificationList getNotificationList() {
        return notificationList;
    }

    public NotificationFactory getNotificationFactory() {
        return notificationFactory;
    }

    public PauseWindow getPauseWindow() {
        return pauseWindow;
    }

    public PauseChecker getPauseChecker() {
        return pauseChecker;
    }

    public ShredderCannonCounter getShredderCannonCounter() {
        return shredderCannonCounter;
    }

    public GatlingGunnerCounter getGatlingGunnerCounter() {
        return gatlingGunnerCounter;
    }

    public ScreenFader getScreenFader() {
        return screenFader;
    }
}
