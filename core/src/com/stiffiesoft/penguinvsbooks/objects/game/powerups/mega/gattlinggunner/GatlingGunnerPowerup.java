package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.gattlinggunner;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;
import com.stiffiesoft.penguinvsbooks.effects.ScreenFader;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.Enemy;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyFactory;
import com.stiffiesoft.penguinvsbooks.objects.game.enemies.spawning.EnemyList;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileList;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.rendering.DefinedColors;

public class GatlingGunnerPowerup extends Powerup {

    private ScreenFader screenFader;
    private EnemyList enemyList;
    private ProjectileList projectileList;
    private EnemyFactory enemyFactory;
    private Player player;
    private boolean fadeDone;
    private boolean counterDone;
    private boolean gunsDone;
    private boolean freezeDone;
    private GatlingGunnerCounterView gatlingGunnerCounterView;
    private GatlingGunnerGuns gatlingGunnerGuns;
    private GatlingGunnerCursor gatlingGunnerCursor;
    private long nextStep;
    private long next;

    public GatlingGunnerPowerup(GameContext context, Transform initial) {
        super(context, initial);
        this.screenFader                = context.getScreenFader();
        this.enemyList                  = context.getEnemyList();
        this.projectileList             = context.getProjectileList();
        this.enemyFactory               = context.getEnemyFactory();
        this.player                     = context.getPlayer();
        this.fadeDone                   = false;
        this.counterDone                = false;
        this.gunsDone                   = false;
        this.freezeDone                 = false;
        this.gatlingGunnerCounterView   = null;
        this.gatlingGunnerGuns          = null;
        this.gatlingGunnerCursor        = null;
        this.nextStep                   = 500;
        updateTime();
        start();
    }

    private void updateTime() {
        this.next = TimeUtils.millis() + nextStep;
    }

    @Override
    protected void start() {

        //Freeze player and enemies
        player.freeze(true);
        for (Enemy enemy : enemyList.getArray())
            enemy.freeze(true);

        //Fade screen
        screenFader.fade(DefinedColors.GATTLING_GUNNER_SCREEN, 0,0.25f);
    }

    @Override
    protected void update() {

        //Wait until screen fading is done
        if (!screenFader.isFading() && !fadeDone && TimeUtils.millis() > next) {

            //Fade done
            fadeDone = true;
            updateTime();

            //Create counter view
            gatlingGunnerCounterView = (GatlingGunnerCounterView)projectileFactory.createGatlingGunnerCounterView(initial.clone());
        }

        //Is fading done
        else if (fadeDone && !counterDone && gatlingGunnerCounterView != null && TimeUtils.millis() > next) {

            //Is the counter view in place?
            if (gatlingGunnerCounterView.isInPlace()) {

                //Counter done
                counterDone = true;
                updateTime();

                //Create guns
                gatlingGunnerGuns = (GatlingGunnerGuns)projectileFactory.createGatlingGunnerGuns(initial.clone());
            }
        }

        //Are guns done
        else if (counterDone && !gunsDone && gatlingGunnerGuns != null && TimeUtils.millis() > next) {

            //Are the guns in place?
            if (gatlingGunnerGuns.isInPlace()) {

                //Gatling guns done
                gunsDone = true;
                updateTime();

                //Create cursor / crosshair
                gatlingGunnerCursor = (GatlingGunnerCursor)projectileFactory.createGatlingGunnerCursor(initial.clone());
            }
        }

        //Is everything unfrozen
        else if (gunsDone && !freezeDone && TimeUtils.millis() > next) {

            //Unfreeze
            player.freeze(false);
            for (Enemy enemy : enemyList.getArray())
                enemy.freeze(false);
            freezeDone = true;


            //Speed up enemy factory
            enemyFactory.setAlert(true);

        //Is everything done
        } else if (freezeDone) {

            //Update counter with gun information
            int ammo = gatlingGunnerGuns.getAmmo();
            gatlingGunnerCounterView.setValue(ammo);

            //Check if no ammo left
            if (ammo <= 0) {

                //Unalert
                enemyFactory.setAlert(false);

                //Create glass
                junkFactory.createGatlingGunnerJunk(initial);
                screenFader.fade(Color.WHITE,0,0);

                //Destroy powerup
                gatlingGunnerCounterView.dispose();
                projectileList.destroy(gatlingGunnerCounterView);
                projectileList.destroy(gatlingGunnerCursor);
                projectileList.destroy(gatlingGunnerGuns);
                powerupList.destroy(this);
            }
        }
    }
}
