package com.stiffiesoft.penguinvsbooks.objects.game.notifications;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Renderable;

import java.util.ArrayList;
import java.util.Iterator;

public class NotificationList {

    private ArrayList<NotificationContent> notifications;
    private ArrayList<NotificationContent> disposableNotifications;

    public NotificationList() {
        notifications               = new ArrayList<>();
        disposableNotifications     = new ArrayList<>();
    }

    public void add(NotificationContent notification) {
        notifications.add(notification);
    }

    public void addLast(NotificationContent notification) {
        notifications.add(notifications.size(),notification);
    }

    public ArrayList<NotificationContent> get() {
        return notifications;
    }

    public void destroy(NotificationContent notification) {

        //Place item in special dispose list
        disposableNotifications.add(notification);
    }

    public void dispose() {

        //Check each notification in the disposable list
        Iterator iterator = disposableNotifications.iterator();
        while (iterator.hasNext()) {

            //Get notification
            NotificationContent notification = (NotificationContent) iterator.next();

            //Destroy object
            notifications.remove(notification);
            iterator.remove();
        }
    }
}