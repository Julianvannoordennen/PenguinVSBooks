package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.clover;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class CloverCatalogueItem  implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.clover();
    }

    @Override
    public int getSpawnChanche() {
        return 200;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createCloverPickup(position);
    }
}

