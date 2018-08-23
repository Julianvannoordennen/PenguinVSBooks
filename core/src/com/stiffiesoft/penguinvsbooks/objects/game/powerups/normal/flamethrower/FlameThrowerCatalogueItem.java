package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.flamethrower;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class FlameThrowerCatalogueItem  implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.flameThrower();
    }

    @Override
    public int getSpawnChanche() {
        return 300;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createFlameThrowerPickup(position);
    }
}
