package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.earthquake;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class EarthquakeCatalogueItem implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.earthquake();
    }

    @Override
    public int getSpawnChanche() {
        return 425;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createEarthquakePickup(position);
    }
}
