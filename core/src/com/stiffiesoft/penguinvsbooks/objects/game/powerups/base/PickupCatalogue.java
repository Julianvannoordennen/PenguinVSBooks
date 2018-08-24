package com.stiffiesoft.penguinvsbooks.objects.game.powerups.base;

import com.stiffiesoft.penguinvsbooks.objects.game.powerups.mega.shreddercannon.ShredderCannonCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.bomb.BombCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.bombbook.BombBookCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.boomerang.BoomerangCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.clover.CloverCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.cookie.CookieCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.dyslexia.DyslexiaCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.earthquake.EarthquakeCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.extralife.ExtraLifeCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.flamethrower.FlameThrowerCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.grenade.GrenadeCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.hacker.HackerCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.helpingbook.HelpingBookCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.katana.KatanaCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.laser.LaserCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.magnet.MagnetCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.megalife.MegaLifeCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.nuke.NukeCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.plasmaturret.PlasmaTurretCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.saw.SawCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.teleporter.TeleporterCatalogueItem;
import com.stiffiesoft.penguinvsbooks.objects.game.powerups.normal.wizard.WizardCatalogueItem;

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
        pickupCatalogueItems.add(new TeleporterCatalogueItem());
        pickupCatalogueItems.add(new MagnetCatalogueItem());
        pickupCatalogueItems.add(new BombCatalogueItem());
        pickupCatalogueItems.add(new KatanaCatalogueItem());
        pickupCatalogueItems.add(new ExtraLifeCatalogueItem());
        pickupCatalogueItems.add(new MegaLifeCatalogueItem());
        pickupCatalogueItems.add(new EarthquakeCatalogueItem());
        pickupCatalogueItems.add(new NukeCatalogueItem());
        pickupCatalogueItems.add(new BoomerangCatalogueItem());
        pickupCatalogueItems.add(new PlasmaTurretCatalogueItem());
        pickupCatalogueItems.add(new HackerCatalogueItem());
        pickupCatalogueItems.add(new DyslexiaCatalogueItem());
        pickupCatalogueItems.add(new FlameThrowerCatalogueItem());
        pickupCatalogueItems.add(new SawCatalogueItem());
        pickupCatalogueItems.add(new WizardCatalogueItem());
        pickupCatalogueItems.add(new CloverCatalogueItem());
        pickupCatalogueItems.add(new BombBookCatalogueItem());
        pickupCatalogueItems.add(new HelpingBookCatalogueItem());
        pickupCatalogueItems.add(new ShredderCannonCatalogueItem());
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
