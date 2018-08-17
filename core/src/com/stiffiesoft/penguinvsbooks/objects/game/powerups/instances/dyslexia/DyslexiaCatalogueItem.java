package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.dyslexia;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class DyslexiaCatalogueItem  implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.dyslexia();
    }

    @Override
    public int getSpawnChanche() {
        return 500;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createDyslexiaPickup(position);
    }
}