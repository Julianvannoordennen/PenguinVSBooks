package com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class ShredderCannonCatalogueItem implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.shredderCannon();
    }

    @Override
    public int getSpawnChanche() {
        return 100;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createShredderCannonPickup(position);
    }
}
