package com.stiffiesoft.penguinvsbooks.objects.game.notifications;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.GameObject;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transform;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;
import com.stiffiesoft.penguinvsbooks.system.assets.A;
import com.stiffiesoft.penguinvsbooks.system.calculations.C;
import com.stiffiesoft.penguinvsbooks.system.rendering.DepthProfiles;

public class PauseWindow implements GameObject, Transformable {

    private NotificationContent currentNotificationContent;
    private GameContext context;
    private NotificationList notificationList;
    private Transform transform;
    private float movementSpeed;
    private float fallSpeed;
    private float currentFallSpeed;
    private Texture texture;
    private Vector2 targetPosition;

    public PauseWindow(GameContext context) {
        this.context                    = context;
        this.notificationList           = context.getNotificationList();
        this.texture                    = A.m.get(A.notificationWindow);
        this.movementSpeed              = C.pH() * 200;
        this.fallSpeed                  = C.pH() * 2.5f;
        this.transform                  = new Transform(0,0,C.pW() * 33, C.pH() * 33,1,1,0);
        this.targetPosition             = new Vector2((C.sW() / 2) - (transform.getWidth() / 2), (C.sH() / 2) - (transform.getHeight() / 2));
        reset();
    }

    private void reset() {

        //Destroy current notification
        this.currentNotificationContent = null;

        //Set the pause window somewhere outside of the screen
        this.transform.setPosition(C.pOS((int)C.pW() * 33));
        this.currentFallSpeed = 0;
    }

    public void showNotification() {

        //Reset position
        reset();

        //Get the first notification from the notificationlist
        currentNotificationContent = notificationList.get().get(0);

        //Since we have the notification, we can remove the notification from the notificationlist
        notificationList.destroy(currentNotificationContent);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch batch) {

        //Render notification content if its not null
        if (currentNotificationContent != null) {

            //Check if the message is done
            if (currentNotificationContent.isDone()) {

                //Lets fall
                currentFallSpeed += fallSpeed * C.cET();
                transform.applyPosition(new Vector2(0,-currentFallSpeed));

                //Check if below position
                if (transform.getYPosition() < -C.sH() / 2) {

                    //Check if there is another notification left
                    if (notificationList.get().size() > 0) {

                        //Grab the next notification
                        showNotification();

                    } else {

                        //Reset
                        reset();

                        //Disable pause
                        context.getPauseChecker().canPause(true);
                        return;
                    }
                }

            } else {

                //Check distance between position and targetposition
                if (transform.getPosition().dst(targetPosition) <= (C.pW() * 5)) {

                    //Apply correct position to transform
                    Vector2 position = new Vector2(targetPosition);
                    position.add(new Vector2(-transform.getXCenter() / 2, -transform.getYCenter() / 2));
                    transform.setPosition(targetPosition);

                    //Content is ready
                    currentNotificationContent.setReady(true);

                } else {

                    //Set the correct movement angle
                    transform.setMovementAngle(C.getAngleInDegrees(transform.getPosition(), targetPosition));

                    //Move to the target position
                    transform.moveInDirection(movementSpeed * C.cET());
                }
            }

            //Render piece of paper
            Transform.draw(batch, texture, transform);

            //Render the notification content
            currentNotificationContent.render(batch, transform.getPosition());
        }
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public int getDepth() {
        return DepthProfiles.NOTIFICATIONS;
    }
}
