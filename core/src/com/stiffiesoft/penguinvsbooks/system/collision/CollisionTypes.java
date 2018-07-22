package com.stiffiesoft.penguinvsbooks.system.collision;

/*

    *** Collision explanation ***

    PLAYER      > *HIT* > ENEMY                 Player damages
    PLAYER      > *HIT* > PICKUP                Pickup activates
    PROJECTILE  > *HIT* > ENEMY                 Enemy damages (And projectile might damage too, depends on projectile type)

    These are all collisions that will exist in the game.
    However, this might expand in the future when new idea's will be realised.
    For example, enemies which can steal pickups sounds like a fun idea.

*/

public class CollisionTypes {

    public static final short PLAYER = 1 << 0;
    public static final short ENEMY = 1 << 1;
    public static final short PROJECTILE = 1 << 2;
    public static final short PICKUP = 1 << 3;
}



