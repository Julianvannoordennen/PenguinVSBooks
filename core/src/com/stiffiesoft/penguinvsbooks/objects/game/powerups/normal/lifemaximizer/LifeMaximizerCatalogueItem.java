package com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.lifemaximizer;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class LifeMaximizerCatalogueItem implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.lifeMaximizer();
    }

    @Override
    public int getSpawnChanche() {
        return 50;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createLifeMaximizerPickup(position);
    }
}

