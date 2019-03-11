package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

//import java.util.HashMap;
//import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class Market {

    private int techLevel;
    private ResourceLevel resourceLevel;
    //private Map<Good, Integer> inventory;
    private List<MarketItem> inventory;

    /**
     * Good constructor
     *
     * @param techLevel The system's techLevel
     * @param resourceLevel The system's resourceLevel
     */
    public Market(int techLevel, ResourceLevel resourceLevel) {
        this.techLevel = techLevel;
        this.resourceLevel = resourceLevel;
        GoodType[] allGoods = GoodType.values();
        inventory = new ArrayList<>();
        int i = 0;
        while(i < allGoods.length && this.techLevel >= allGoods[i].getMinTechToUse()) {
            inventory.add(new MarketItem(allGoods[i], calcPrice(allGoods[i])));
            i++;
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
