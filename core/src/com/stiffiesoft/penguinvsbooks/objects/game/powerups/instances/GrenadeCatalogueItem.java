package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class GrenadeCatalogueItem implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.grenade();
    }

    @Override
    public int getSpawnChanche() {
        return 1000;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createGrenadePickup(position);
    }
}
