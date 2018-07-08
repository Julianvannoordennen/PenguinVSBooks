package com.stiffiesoft.penguinvsbooks.objects.game.enemies.targetting;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.scenes.game.utility.Transformable;

import java.util.ArrayList;

public class EnemyTargetSystem {

    public static ArrayList<Transformable> targets = new ArrayList<>();

    public static Transformable getNearestTarget(Vector2 enemyPosition) {

        //Check which target to send
        if (targets.size() == 1) {
            return targets.get(0);
        } else if (targets.size() == 0) {
            return null;
        } else {

            //Go through all targets and see which one is closest
            Transformable nearest = targets.get(0);
            float distance = enemyPosition.dst(nearest.getTransform().getPosition());
            for(int index = 1; index < targets.size(); index++) {

                //Check distance
                float newDistance = enemyPosition.dst(targets.get(index).getTransform().getPosition());
                if (newDistance < distance) {
                    nearest = targets.get(index);
                    distance = newDistance;
                }
            }

            //Return
            return nearest;
        }
    }

    public static void registerTarget(Transformable target) {
        targets.add(target);
    }
}
