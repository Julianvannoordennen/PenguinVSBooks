package com.stiffiesoft.penguinvsbooks.system.rendering;

public class DepthProfiles {

    /*

        Depth profiles

        0       = more to the background (And will likely be covered by another object
        10000   = more to the foreground (And will likely not be covered by another object

     */

    //Game objects
    public static final int INVISIBLE = -100;               //Just a placeholder value for gameobjects that don't need to be rendered at all
    public static final int JUNK_BACKGROUND = 0;
    public static final int PICKUPS = 100;
    public static final int PROJECTILES_BACKGROUND = 200;
    public static final int PLAYER = 300;
    public static final int ENEMIES = 300;
    public static final int JUNK_FOREGROUND = 500;
    public static final int PROJECTILES_FOREGROUND = 600;
    public static final int PROJECTILES_LASER = 700;        //Laser should be above all other foreground projectiles

    //UI objects
    public static final int COUNTERS = 800;
    public static final int NOTIFICATIONS = 900;

    //Effects
    public static final int SCREEN_BORDER = 1000;
    public static final int SCREEN_FLASHER = 1100;
}
