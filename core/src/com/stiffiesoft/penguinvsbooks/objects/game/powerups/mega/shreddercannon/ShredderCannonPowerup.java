package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class ShredderCannonPowerup extends Powerup {

    private int currentPart;
    private ShredderCannonPart currentShredderCannonPart;
    private ShredderCannonPart[] shredderCannonParts;
    private ShredderCannonBase shredderCannonBase;
    private ProjectileList projectileList;
    private EnemyFactory enemyFactory;
    private EnemyList enemyList;
    private boolean cannonCreated;
    private Player player;

    public ShredderCannonPowerup(GameContext context, Transform initial) {
        super(context, initial);
        this.enemyList              = context.getEnemyList();
        this.currentPart            = 1;
        this.shredderCannonParts    = new ShredderCannonPart[4];
        this.projectileList         = context.getProjectileList();
        this.cannonCreated          = false;
        this.shredderCannonBase     = null;
        this.player                 = context.getPlayer();
        this.enemyFactory           = context.getEnemyFactory();
        createShredderCannonPart();
        start();
    }

    @Override
    protected void start() {

        //Freeze player and enemies
        player.freeze(true);
        for (Enemy enemy : enemyList.getArray())
            enemy.freeze(true);

        //Center is now our location
        initial.setPosition(new Vector2(C.sW() / 2, C.sH() / 2));
    }

    @Override
    protected void update() {

        //Check cannon parts
        if (!cannonCreated)
            checkCannonParts();
        else
            checkCannonBase();
    }

    private void checkCannonParts() {

        //Check if the first part is done
        if (currentShredderCannonPart.isInPlace()) {

            //Check if we are done
            if (currentPart == 5) {

                //Create explosion
                projectileFactory.createShredderCannonExplosion(initial);

                //Create cannon
                shredderCannonBase = (ShredderCannonBase)projectileFactory.createShredderCannonBase(initial);
                cannonCreated = true;

                //Move player
                player.getTransform().setPosition(initial.getPosition());
                player.getTransform().applyPosition(new Vector2(player.getTransform().getWidth() / -2, player.getTransform().getHeight() / -2));

                //Unfreeze enemeis
                for (Enemy enemy : enemyList.getArray())
                    enemy.freeze(false);

                //Alert enemyfactory
                enemyFactory.setAlert(true);

            } else

                //Time for the next part
                createShredderCannonPart();
        }
    }

    private void checkCannonBase() {

        //Rotate player
        player.getTransform().setRotation(shredderCannonBase.getTransform().getRotation());

        //Check if the shredder cannon does not exist
        if (!projectileList.getArray().contains(shredderCannonBase)) {

            //Unfreeze player
            player.freeze(false);

            //Unalert enemyfactory
            enemyFactory.setAlert(false);

            //Destroy everything
            for (ShredderCannonPart part : shredderCannonParts)
                projectileList.destroy(part);
            powerupList.destroy(this);
        }
    }

    private void createShredderCannonPart() {

        //Create transform
        Transform transform = null;

        switch (currentPart) {

            case 1:

                transform = new Transform(
                        (C.sW() / 2) - C.sW(),
                        (C.sH() / 2) + C.sH(),
                        C.pH() * 37.5f,
                        C.pH() * 37.5f,
                        1,
                        1,
                        0,
                        C.pH() * 37.5f,
                        0
                );
                break;

            case 2:

                transform = new Transform(
                        (C.sW() / 2) - C.sW(),
                        (C.sH() / 2) - C.sH(),
                        C.pH() * 37.5f,
                        C.pH() * 37.5f,
                        1,
                        1,
                        0,
                        C.pH() * 37.5f,
                        C.pH() * 37.5f
                );
                break;

            case 3:

                transform = new Transform(
                        (C.sW() / 2) + C.sW(),
                        (C.sH() / 2) - C.sH(),
                        C.pH() * 37.5f,
                        C.pH() * 37.5f,
                        1,
                        1,
                        0,
                        0,
                        C.pH() * 37.5f
                );
                break;

            case 4:

                transform = new Transform(
                        (C.sW() / 2) + C.sW(),
                        (C.sH() / 2) + C.sH(),
                        C.pH() * 37.5f,
                        C.pH() * 37.5f,
                        1,
                        1,
                        0,
                        0,
                        0
                );
                break;
        }

        //Create part
        currentShredderCannonPart               = (ShredderCannonPart)projectileFactory.createShredderCannonPart(transform);
        shredderCannonParts[currentPart - 1]    = currentShredderCannonPart;
        currentShredderCannonPart.setPartPiece(currentPart);
        currentPart++;
    }
}
