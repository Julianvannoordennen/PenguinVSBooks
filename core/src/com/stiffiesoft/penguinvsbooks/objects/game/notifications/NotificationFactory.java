package com.stiffiesoft.penguinvsbooks.objects.game.notifications;

import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;

public class NotificationFactory {

    private GameContext context;
    private NotificationList notificationList;

    public NotificationFactory(GameContext context) {
        this.context            = context;
        this.notificationList   = context.getNotificationList();
    }

    /***** Create methods *****/
    public NotificationContent createPauseNotification() {

        //Create notification content
        PauseNotificationContent content = new PauseNotificationContent(context);

        //Add notification to the list so the program can keep track of it
        //The pause notification will always be on the end of the list
        notificationList.addLast(content);

        //Return notification content
        return content;
    }
}
