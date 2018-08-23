package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.teleporter;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class TeleporterCatalogueItem implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.teleporter();
    }

    @Override
    public int getSpawnChanche() {
        return 500;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createTeleporterPickup(position);
    }
}
