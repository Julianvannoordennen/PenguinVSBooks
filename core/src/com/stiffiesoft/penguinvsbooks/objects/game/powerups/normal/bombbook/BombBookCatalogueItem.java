package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.bombbook;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class BombBookCatalogueItem  implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.bombBook();
    }

    @Override
    public int getSpawnChanche() {
        return 400;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createBombBookPickup(position);
    }
}
