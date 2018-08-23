package com.stiffiesoft.penguinvsbooks.system.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

//Asset manager
public class A {

    //Enemies
    public static final AssetDescriptor<TextureAtlas> defaultBookEnemyAtlas     = new AssetDescriptor<>("sprites/game/enemies/defaultBookEnemy/default_book_enemy.atlas", TextureAtlas.class);

    //Player
    public static final AssetDescriptor<Texture> playerIdle                     = new AssetDescriptor<>("sprites/game/player/player_idle.png", Texture.class);
    public static final AssetDescriptor<Texture> playerProjectile               = new AssetDescriptor<>("sprites/game/player/player_projectile.png", Texture.class);

    //Pickups
    public static final AssetDescriptor<Texture> grenadePickup                  = new AssetDescriptor<>("sprites/game/powerups/grenade/grenade_pickup.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> cookiePickup              = new AssetDescriptor<>("sprites/game/powerups/cookie/cookie_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<Texture> laserPickup                    = new AssetDescriptor<>("sprites/game/powerups/laser/laser_pickup.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> teleporterPickup          = new AssetDescriptor<>("sprites/game/powerups/teleporter/teleporter_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> magnetPickup              = new AssetDescriptor<>("sprites/game/powerups/magnet/magnet_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> bombPickup                = new AssetDescriptor<>("sprites/game/powerups/bomb/bomb_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<Texture> katanaPickup                   = new AssetDescriptor<>("sprites/game/powerups/katana/katana_pickup.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> extraLifePickup           = new AssetDescriptor<>("sprites/game/powerups/extralife/extra_life_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> megaLifePickup            = new AssetDescriptor<>("sprites/game/powerups/megalife/mega_life_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<Texture> earthquakePickup               = new AssetDescriptor<>("sprites/game/powerups/earthquake/earthquake_pickup.png", Texture.class);
    public static final AssetDescriptor<Texture> nukePickup                     = new AssetDescriptor<>("sprites/game/powerups/nuke/nuke_pickup.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> boomerangPickup           = new AssetDescriptor<>("sprites/game/powerups/boomerang/boomerang_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<Texture> plasmaTurretPickup             = new AssetDescriptor<>("sprites/game/powerups/plasmaturret/plasma_turret_pickup.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> hackerPickup              = new AssetDescriptor<>("sprites/game/powerups/hacker/hacker_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> dyslexiaPickup            = new AssetDescriptor<>("sprites/game/powerups/dyslexia/dyslexia_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> flameThrowerPickup        = new AssetDescriptor<>("sprites/game/powerups/flamethrower/flame_thrower_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<Texture> sawPickup                      = new AssetDescriptor<>("sprites/game/powerups/saw/saw_pickup.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> wizardPickup              = new AssetDescriptor<>("sprites/game/powerups/wizard/wizard_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> cloverPickup              = new AssetDescriptor<>("sprites/game/powerups/clover/clover_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> bombBookPickup            = new AssetDescriptor<>("sprites/game/powerups/bombbook/bomb_book_pickup.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> helpingBookPickup         = new AssetDescriptor<>("sprites/game/powerups/helpingbook/helping_book_pickup.atlas", TextureAtlas.class);

    //Powerups
    public static final AssetDescriptor<Texture> explosion                      = new AssetDescriptor<>("sprites/game/projectiles/explosion.png", Texture.class);
    public static final AssetDescriptor<Texture> cookiePowerup                  = new AssetDescriptor<>("sprites/game/powerups/cookie/cookie_powerup.png", Texture.class);
    public static final AssetDescriptor<Texture> laserPowerup                   = new AssetDescriptor<>("sprites/game/powerups/laser/laser_powerup.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> teleporterShock           = new AssetDescriptor<>("sprites/game/powerups/teleporter/teleporter_shock.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> magnetShock               = new AssetDescriptor<>("sprites/game/powerups/magnet/magnet_shock.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> bombProjectile            = new AssetDescriptor<>("sprites/game/powerups/bomb/bomb_projectile.atlas", TextureAtlas.class);
    public static final AssetDescriptor<Texture> boomerangProjectile            = new AssetDescriptor<>("sprites/game/powerups/boomerang/boomerang_projectile.png", Texture.class);
    public static final AssetDescriptor<Texture> plasmaTurretPowerup            = new AssetDescriptor<>("sprites/game/powerups/plasmaturret/plasma_turret_powerup.png", Texture.class);
    public static final AssetDescriptor<Texture> plasmaTurretProjectile         = new AssetDescriptor<>("sprites/game/powerups/plasmaturret/plasma_turret_projectile.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> plasmaTurretPowerupFire   = new AssetDescriptor<>("sprites/game/powerups/plasmaturret/plasma_turret_powerup_fire.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> hackerProjectile          = new AssetDescriptor<>("sprites/game/powerups/hacker/hacker_projectile.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> hackerEnemy               = new AssetDescriptor<>("sprites/game/powerups/hacker/hacker_enemy.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> dyslexiaEnemy             = new AssetDescriptor<>("sprites/game/powerups/dyslexia/dyslexia_enemy.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> wizardEnemy               = new AssetDescriptor<>("sprites/game/powerups/wizard/wizard_enemy.atlas", TextureAtlas.class);
    public static final AssetDescriptor<Texture> wizardProjectile1              = new AssetDescriptor<>("sprites/game/powerups/wizard/wizard_projectile_1.png", Texture.class);
    public static final AssetDescriptor<Texture> wizardProjectile2              = new AssetDescriptor<>("sprites/game/powerups/wizard/wizard_projectile_2.png", Texture.class);
    public static final AssetDescriptor<Texture> wizardProjectile3              = new AssetDescriptor<>("sprites/game/powerups/wizard/wizard_projectile_3.png", Texture.class);
    public static final AssetDescriptor<Texture> wizardProjectile4              = new AssetDescriptor<>("sprites/game/powerups/wizard/wizard_projectile_4.png", Texture.class);
    public static final AssetDescriptor<Texture> wizardProjectile5              = new AssetDescriptor<>("sprites/game/powerups/wizard/wizard_projectile_5.png", Texture.class);
    public static final AssetDescriptor<Texture> wizardProjectile6              = new AssetDescriptor<>("sprites/game/powerups/wizard/wizard_projectile_6.png", Texture.class);
    public static final AssetDescriptor<Texture> wizardProjectile7              = new AssetDescriptor<>("sprites/game/powerups/wizard/wizard_projectile_7.png", Texture.class);
    public static final AssetDescriptor<Texture> wizardProjectile8              = new AssetDescriptor<>("sprites/game/powerups/wizard/wizard_projectile_8.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> bombBookEnemy             = new AssetDescriptor<>("sprites/game/powerups/bombbook/bomb_book_enemy.atlas", TextureAtlas.class);
    public static final AssetDescriptor<Texture> bombBookProjectile             = new AssetDescriptor<>("sprites/game/powerups/bombbook/bomb_book_projectile.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> helpingBookEnemy          = new AssetDescriptor<>("sprites/game/powerups/helpingbook/helping_book_enemy.atlas", TextureAtlas.class);

    //Junk
    public static final AssetDescriptor<Texture> defaultBookEnemyJunk1          = new AssetDescriptor<>("sprites/game/enemies/defaultBookEnemy/default_book_enemy_junk_1.png", Texture.class);
    public static final AssetDescriptor<Texture> defaultBookEnemyJunk2          = new AssetDescriptor<>("sprites/game/enemies/defaultBookEnemy/default_book_enemy_junk_2.png", Texture.class);
    public static final AssetDescriptor<Texture> explosionDust                  = new AssetDescriptor<>("sprites/game/projectiles/explosion_dust.png", Texture.class);
    public static final AssetDescriptor<Texture> pickupSpark                    = new AssetDescriptor<>("sprites/game/powerups/pickup_spark.png", Texture.class);
    public static final AssetDescriptor<Texture> cookieJunk1                    = new AssetDescriptor<>("sprites/game/powerups/cookie/cookie_junk_1.png", Texture.class);
    public static final AssetDescriptor<Texture> cookieJunk2                    = new AssetDescriptor<>("sprites/game/powerups/cookie/cookie_junk_2.png", Texture.class);
    public static final AssetDescriptor<Texture> plasmaTurretJunk1              = new AssetDescriptor<>("sprites/game/powerups/plasmaturret/plasma_turret_junk_1.png", Texture.class);
    public static final AssetDescriptor<Texture> plasmaTurretJunk2              = new AssetDescriptor<>("sprites/game/powerups/plasmaturret/plasma_turret_junk_2.png", Texture.class);
    public static final AssetDescriptor<Texture> plasmaTurretJunk3              = new AssetDescriptor<>("sprites/game/powerups/plasmaturret/plasma_turret_junk_3.png", Texture.class);
    public static final AssetDescriptor<Texture> plasmaTurretJunk4              = new AssetDescriptor<>("sprites/game/powerups/plasmaturret/plasma_turret_junk_4.png", Texture.class);
    public static final AssetDescriptor<Texture> plasmaTurretJunk5              = new AssetDescriptor<>("sprites/game/powerups/plasmaturret/plasma_turret_junk_5.png", Texture.class);
    public static final AssetDescriptor<Texture> dyslexiaJunk                   = new AssetDescriptor<>("sprites/game/powerups/dyslexia/dyslexia_junk.png", Texture.class);
    public static final AssetDescriptor<Texture> sawJunk1                       = new AssetDescriptor<>("sprites/game/powerups/saw/saw_junk_1.png", Texture.class);
    public static final AssetDescriptor<Texture> sawJunk2                       = new AssetDescriptor<>("sprites/game/powerups/saw/saw_junk_2.png", Texture.class);
    public static final AssetDescriptor<Texture> cloverJunk                     = new AssetDescriptor<>("sprites/game/powerups/clover/clover_junk.png", Texture.class);

    //Effects
    public static final AssetDescriptor<Texture> screenBorder                   = new AssetDescriptor<>("effects/border_screen.png", Texture.class);
    public static final AssetDescriptor<Texture> screenFader                    = new AssetDescriptor<>("effects/screenfade.png", Texture.class);
    public static final AssetDescriptor<BitmapFont> defaultFont                 = new AssetDescriptor<>("fonts/default.fnt", BitmapFont.class);

    //Menu and pause
    public static final AssetDescriptor<Texture> notificationWindow             = new AssetDescriptor<>("sprites/game/notifications/notification_window.png", Texture.class);
    public static final AssetDescriptor<Texture> menuLogo                       = new AssetDescriptor<>("sprites/menu/menu_logo.png", Texture.class);
    public static final AssetDescriptor<Texture> playButton                     = new AssetDescriptor<>("sprites/menu/button_play.png", Texture.class);
    public static final AssetDescriptor<Texture> statisticsButton               = new AssetDescriptor<>("sprites/menu/button_statistics.png", Texture.class);
    public static final AssetDescriptor<Texture> upgradesButton                 = new AssetDescriptor<>("sprites/menu/button_upgrades.png", Texture.class);
    public static final AssetDescriptor<Texture> archievementsButton            = new AssetDescriptor<>("sprites/menu/button_archievements.png", Texture.class);
    public static final AssetDescriptor<Texture> settingsButton                 = new AssetDescriptor<>("sprites/menu/button_settings.png", Texture.class);
    public static final AssetDescriptor<Texture> quitButton                     = new AssetDescriptor<>("sprites/menu/button_quit.png", Texture.class);

    //Manager
    public static final AssetManager m                                          = new AssetManager();
    public static void dispose() {
        m.dispose();
    }

    //Load all assets automaticaly, because I'm lazy
    public static void load() {

        try {

            //Get all fields from this A class
            Field[] declaredFields = A.class.getDeclaredFields();

            //For each field
            for (Field field : declaredFields) {

                //Check if it is static and a assetdescriptor
                if (Modifier.isStatic(field.getModifiers()) && AssetDescriptor.class.isAssignableFrom(field.getType())) {

                    //Load
                    m.load((AssetDescriptor<?>)field.get(field));
                }
            }
        } catch(Exception e) {

            //Fatal error
            System.out.println("Fatal error loading assets: " + e);

            //Quit application
            Gdx.app.exit();
        }
    }
}
