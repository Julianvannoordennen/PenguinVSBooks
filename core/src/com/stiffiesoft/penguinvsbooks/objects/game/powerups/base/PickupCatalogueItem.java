package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.badlogic.gdx.math.Vector2;

public interface PickupCatalogueItem {

    String getName();
    int getSpawnChanche();
    void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position);

}
