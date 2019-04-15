package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

/**
 * Houses all of good's integer attributes
 *
 * @author Sam Quiroz
 * @version 1.0
 */
class GoodTypeInts {

    private final int minTechToProduce;
    private final int minTechToUse;
    private final int techMostProduce;
    private final int basePrice;
    private final int priceIncPerLevel;
    private final int variance;

    /**
     * Initializes a GoodTypeInts
     *
     * @param minTechToProduce min tech level to produce resource
     * @param minTechToUse min tech level to use resource
     * @param techMostProduce tech level that produces most of resource
     * @param basePrice base price of resource
     * @param priceIncPerLevel price increase per tech level
     * @param variance max percentage price can vary above or below base
     */
    public GoodTypeInts(int minTechToProduce, int minTechToUse, int techMostProduce,
                        int basePrice, int priceIncPerLevel, int variance) {
        this.minTechToProduce = minTechToProduce;
        this.minTechToUse = minTechToUse;
        this.techMostProduce = techMostProduce;
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
        return minTechToProduce;
    }

    /**
     * @return Minimum TechLevel to use
     */
    public int getMinTechToUse() {
        return minTechToUse;
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
        return techMostProduce;
    }
}
