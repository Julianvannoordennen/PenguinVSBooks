package com.stiffiesoft.penguinvsbooks.system.collision;

import com.badlogic.gdx.physics.box2d.World;
import com.stiffiesoft.penguinvsbooks.scenes.game.GameContext;

import java.util.ArrayList;
import java.util.Iterator;

public class BodyFactory {

    private ArrayList<BodyTask> tasks;
    private World world;

    public BodyFactory(GameContext context) {
        this.tasks = new ArrayList<>();
        this.world = context.getWorld();
    }

    //Add a single task to the queue
    public void addTask(BodyTask task) {
        this.tasks.add(task);
    }

    //Execute all tasks inside the tasks arraylist, will be executed each frame
    public void executeTasks() {

        //Get the iterator from the tasks array, we need the iterator so we can remove instances from the arraylist
        Iterator iterator = this.tasks.iterator();
        while(iterator.hasNext()) {

            //Get the nearest task in the array
            BodyTask task = (BodyTask)iterator.next();

            //Execute the task
            task.execute(world);

            //Remove the task from the queue (Array)
            iterator.remove();
        }
    }
}
