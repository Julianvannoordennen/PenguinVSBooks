package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.nuke;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class NukeCatalogueItem implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.nuke();
    }

    @Override
    public int getSpawnChanche() {
        return 50;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createNukePickup(position);
    }
}
