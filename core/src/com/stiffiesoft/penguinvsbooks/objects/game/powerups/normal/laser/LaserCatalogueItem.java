package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.laser;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class LaserCatalogueItem implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.laser();
    }

    @Override
    public int getSpawnChanche() {
        return 350;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createLaserPickup(position);
    }
}
