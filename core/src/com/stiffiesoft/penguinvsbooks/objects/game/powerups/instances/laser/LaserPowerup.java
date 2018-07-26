package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.player.Player;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.Powerup;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PowerupList;
import com.stiffiesoft.penguinvsbooks.objects.game.projectiles.ProjectileFactory;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;

public class LaserPowerup extends Powerup {

    public LaserPowerup(GameContext context, Transform initial) {
        super(context, initial);
        start();
    }

    @Override
    protected void start() {

        //Create laser
        LaserProjectile laserProjectile = projectileFactory.createLaserProjectile(initial);

        //Vertical or horizontal
        boolean horizontal = MathUtils.randomBoolean();

        //Will the laser spawn at the player position
        boolean startAtPlayer = MathUtils.randomBoolean();

        //Make it scale the whole screen
        Transform transform = laserProjectile.getTransform();

        if (horizontal) {

            //Let it sit on the bottom of the screen
            transform.setHeight(C.sH());

            //Define position
            if (startAtPlayer && player != null)
                transform.setPosition(new Vector2(player.getTransform().getXPosition(),0));
            else
                transform.setPosition(new Vector2(MathUtils.random(C.pW() * 20, C.sW() - (C.pW() * 20)), 0));

        } else {

            //Let it sit on the side of the screen
            transform.setHeight(C.sW());
            transform.rotate(90);
            float height = MathUtils.random(-(C.sH() - (C.pH() * 40)),-(C.pH() * 20));

            //Define position
            if (startAtPlayer && player != null)
                transform.setPosition(new Vector2(C.sH() - C.pH() * 20,player.getTransform().getYPosition() - C.pH() * 80));
            else
                transform.setPosition(new Vector2(C.sH() - C.pH() * 20,height));
        }

        //Set laser width
        transform.setWidth(C.pW() * 10);
        transform.setCenter(new Vector2(transform.getWidth() / 2, transform.getHeight() / 2));

        //Set flash size
        laserProjectile.setFlashSize(MathUtils.random(1f,2f), 0.25f);

        //Set color
        Color[] colors = {Color.RED, Color.BLUE,Color.GREEN, Color.YELLOW, Color.WHITE, Color.CYAN, Color.CORAL, Color.LIME, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.ORANGE, Color.PURPLE, Color.VIOLET};
        laserProjectile.setColor(colors[MathUtils.random(0,colors.length - 1)]);

        //Decide if the laser will stand still, move to the left or the right and in which speed
        boolean move = MathUtils.randomBoolean();
        boolean inverted = MathUtils.randomBoolean();
        float speed = move ? MathUtils.random(50f,150f) : 0;
        speed = inverted ? -speed : speed;
        laserProjectile.setMovement(horizontal,speed);

        //Done, destroy the powerup
        powerupList.destroy(this);
    }

    @Override
    protected void update() {
    }
}