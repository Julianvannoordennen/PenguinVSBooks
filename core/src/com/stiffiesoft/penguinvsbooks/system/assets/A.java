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

    //Manager
    public static final AssetManager m = new AssetManager();
    public static void dispose() {
        m.dispose();
    }




    // ##### Asset definitions ##### //

    //Enemies
    public static final AssetDescriptor<TextureAtlas> defaultBookEnemyAtlas = new AssetDescriptor<>("sprites/game/enemies/defaultBookEnemy/default_book_enemy.atlas", TextureAtlas.class);

    //Player
    public static final AssetDescriptor<Texture> playerIdle = new AssetDescriptor<>("sprites/game/player/player_idle.png", Texture.class);
    public static final AssetDescriptor<Texture> playerProjectile = new AssetDescriptor<>("sprites/game/player/player_projectile.png", Texture.class);

    //Pickups
    public static final AssetDescriptor<Texture> grenadePickup = new AssetDescriptor<>("sprites/game/powerups/grenade/grenade_pickup.png", Texture.class);
    public static final AssetDescriptor<Texture> cookiePickup = new AssetDescriptor<>("sprites/game/powerups/cookie/cookie_pickup.png", Texture.class);
    public static final AssetDescriptor<Texture> laserPickup = new AssetDescriptor<>("sprites/game/powerups/laser/laser_pickup.png", Texture.class);

    //Powerups
    public static final AssetDescriptor<Texture> explosion = new AssetDescriptor<>("sprites/game/projectiles/explosion.png", Texture.class);
    public static final AssetDescriptor<Texture> laserPowerup = new AssetDescriptor<>("sprites/game/powerups/laser/laser_powerup.png", Texture.class);

    //Menu
    public static final AssetDescriptor<Texture> menuLogo = new AssetDescriptor<>("sprites/menu/menu_logo.png", Texture.class);
    public static final AssetDescriptor<Texture> playButton = new AssetDescriptor<>("sprites/menu/button_play.png", Texture.class);
    public static final AssetDescriptor<Texture> statisticsButton = new AssetDescriptor<>("sprites/menu/button_statistics.png", Texture.class);
    public static final AssetDescriptor<Texture> upgradesButton = new AssetDescriptor<>("sprites/menu/button_upgrades.png", Texture.class);
    public static final AssetDescriptor<Texture> archievementsButton = new AssetDescriptor<>("sprites/menu/button_archievements.png", Texture.class);
    public static final AssetDescriptor<Texture> settingsButton = new AssetDescriptor<>("sprites/menu/button_settings.png", Texture.class);
    public static final AssetDescriptor<Texture> quitButton = new AssetDescriptor<>("sprites/menu/button_quit.png", Texture.class);

    //Effects
    public static final AssetDescriptor<Texture> screenBorder = new AssetDescriptor<>("effects/border_screen.png", Texture.class);
    public static final AssetDescriptor<Texture> screenFader = new AssetDescriptor<>("effects/screenfade.png", Texture.class);

    //System
    public static final AssetDescriptor<BitmapFont> defaultFont = new AssetDescriptor<>("fonts/default.fnt", BitmapFont.class);

    // ##### End asset definitions ##### //




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
