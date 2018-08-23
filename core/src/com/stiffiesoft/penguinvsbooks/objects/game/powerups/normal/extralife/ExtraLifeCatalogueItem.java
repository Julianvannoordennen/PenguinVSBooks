package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.extralife;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class ExtraLifeCatalogueItem implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.extraLife();
    }

    @Override
    public int getSpawnChanche() {
        return 50;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createExtraLifePickup(position);
    }
}
