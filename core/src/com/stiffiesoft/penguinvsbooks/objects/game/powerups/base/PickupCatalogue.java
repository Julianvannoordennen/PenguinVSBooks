package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.cookie.CookieCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.grenade.GrenadeCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.instances.laser.LaserCatalogueItem;

import java.util.ArrayList;

public class PickupCatalogue {

    private ArrayList<PickupCatalogueItem> pickupCatalogueItems;
    private int totalSpawnChanche;

    public PickupCatalogue() {
        pickupCatalogueItems = new ArrayList<>();
        totalSpawnChanche = 0;
        loadItems();
        loadGeneralData();
    }

    private void loadItems() {

        //Load all catalogue items
        pickupCatalogueItems.add(new GrenadeCatalogueItem());
        pickupCatalogueItems.add(new CookieCatalogueItem());
        pickupCatalogueItems.add(new LaserCatalogueItem());
    }

    private void loadGeneralData() {

        //Load the total spawn chanche
        for(PickupCatalogueItem item : pickupCatalogueItems)
            totalSpawnChanche += item.getSpawnChanche();
    }

    public PickupCatalogueItem getItemBySpawnChanche(int number) {

        //Create a current value
        int current = 0;
        int index = 0;
        while (current < totalSpawnChanche) {

            //Get item
            PickupCatalogueItem item = pickupCatalogueItems.get(index);

            //Get spawnchanche of catalogueitem
            int chanche = item.getSpawnChanche();

            //Check if the number is between the current and the current + chanche
            if (number >= current && number < current + chanche)
                return item;
            else {
                current += chanche;
                index++;
            }
        }

        //Nothing found? Well that's weird, return the first item in the itemlist as backup
        return pickupCatalogueItems.get(0);
    }

    public int getTotalSpawnChanche() {
        return totalSpawnChanche;
    }
}
