package com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.plasmaturret;

import com.badlogic.gdx.math.Vector2;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.base.PickupFactory;
import com.stiffiesoft.penguinvsbooks.system.text.S;

public class PlasmaTurretCatalogueItem implements PickupCatalogueItem {

    @Override
    public String getName() {
        return S.plasmaTurret();
    }

    @Override
    public int getSpawnChanche() {
        return 250;
    }

    @Override
    public void executeFactoryFunction(PickupFactory pickupFactory, Vector2 position) {
        pickupFactory.createNukePickup(position);
    }
}
