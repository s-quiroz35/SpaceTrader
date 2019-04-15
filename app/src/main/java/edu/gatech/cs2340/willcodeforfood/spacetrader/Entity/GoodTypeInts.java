package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Houses all of good's integer attributes
 *
 * @author Sam Quiroz
 * @version 1.0
 */
class GoodTypeInts {

    private final GoodTypeTechLevelVars goodTypeTechLvlVars;
    private final int basePrice;
    private final int priceIncPerLevel;
    private final int variance;

    /**
     * Initializes a GoodTypeInts
     *
     * @param goodTypeTechLvlVars the tech level related attributes
     * @param basePrice base price of resource
     * @param priceIncPerLevel price increase per tech level
     * @param variance max percentage price can vary above or below base
     */
    public GoodTypeInts(GoodTypeTechLevelVars goodTypeTechLvlVars,
                            int basePrice, int priceIncPerLevel, int variance) {
        this.goodTypeTechLvlVars = goodTypeTechLvlVars;
        this.basePrice = basePrice;
        this.priceIncPerLevel = priceIncPerLevel;
        this.variance = variance;
    }

    /**
     * @return variance
     */
    public int getVariance() {
        return variance;
    }

    /**
     * @return basePrice
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     * @return Minimum TechLevel required to produce
     */
    public int getMinTechToProduce() {
        return goodTypeTechLvlVars.getMinTechToProduce();
    }

    /**
     * @return Minimum TechLevel to use
     */
    public int getMinTechToUse() {
        return goodTypeTechLvlVars.getMinTechToUse();
    }

    /**
     * @return price increase per level
     */
    public int getPriceIncPerLevel() {
        return priceIncPerLevel;
    }

    /**
     * @return tech level that produces the most
     */
    public int getTechMostProduce() {
        return goodTypeTechLvlVars.getTechMostProduce();
    }
}
