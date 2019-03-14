package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

import edu.gatech.cs2340.willcodeforfood.spacetrader.Model.Model;

public class Market {

    Planet planet;
    Cargo cargo;
    private int techLevel;
    private ResourceLevel resourceLevel;
    private List<MarketItem> inventory;
    private List<CargoItem> cargoContents;

    /**
     * Good constructor
     *
     */
    public Market() {
        planet = Model.getInstance().getCurrentPlanet();
        techLevel = planet.getTechLevel().getTechLevel();
        resourceLevel = planet.getResourceLevel();
        cargo = Model.getInstance().getCargo();

        GoodType[] allGoods = GoodType.values();
        inventory = new ArrayList<>();
        int i = 0;
        while(i < allGoods.length && this.techLevel >= allGoods[i].getMinTechToUse()) {
            inventory.add(new MarketItem(allGoods[i], calcPrice(allGoods[i])));
            i++;
        }
        List<CargoItem> cargoContents = cargo.getInventory();
        for (CargoItem c: cargoContents) {
            int price = calcPrice(c.getType());
            c.setPrice(price);
        }

    }

    /**
     * Calculates the price of a good and either doubles it or
     * halves it depending on if the SolarSystem meets the resourceLevel requirements
     *
     * @return Final price of the good
     */
    public int calcPrice(GoodType good) {
        int price = good.getBasePrice() + good.getPriceIncPerLevel()
                * (techLevel - good.getMinTechToProduce()) + (int) (good.getBasePrice()
                * Math.random() * ((double) good.getVariance() / 100));
        if (!(this.resourceLevel.equals(ResourceLevel.NOSPECIALRESOURCES))) {
            if (this.resourceLevel.equals(good.getPriceIncEvent())) {
                return price * 2;
            } else if (this.resourceLevel.equals(good.getPriceDecEvent())) {
                return price / 2;
            }
        }
        return price;
    }

    /**
     * If a new cargo item is added to the cargo, initialize new price
     * @param cargoItem the CargoItem
     */
    public void setNewCargoPrice(CargoItem cargoItem) {
        int price = calcPrice(cargoItem.getType());
        cargoItem.setPrice(price);
    }
    /**
     * @param good The kind of good you want the price of
     * @return How much the good costs
     */
    public int getGoodPrice(GoodType good) {
        int i = 0;
        while (i < inventory.size()) {
            if (inventory.get(i).getType().equals(good)) {
                return inventory.get(i).getPrice();
            }
            i++;
        }
        return 0;
    }

    /**
     * @return the trader's inventory
     */
    public List<MarketItem> getInventory() {
        return inventory;
    }

    /**
     * @return the trader's tech level
     */
    public int getTechLevel() {
        return techLevel;
    }
}
