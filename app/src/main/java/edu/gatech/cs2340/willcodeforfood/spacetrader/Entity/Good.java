package edu.gatech.cs2340.willcodeforfood.spacetrader.Entity;

public class Good {
    //good implementation
    int minTechLvlMk;
    int minTechLvlUse;
    int techWMostProd;
    int basePrice;
    int priceIncPerLvl;
    int variance;
    //int increaseEvent;
    ResourceLevel lowPriceCondition;
    ResourceLevel highPriceCondition;

    public Good(int minTechLvlMk, int minTechLvlUse, int techWMostProd,int basePrice,
                int priceIncPerLvl, int variance, ResourceLevel lowPriceCondition,
                ResourceLevel highPriceCondition) {
        this.minTechLvlMk = minTechLvlMk;
        this.minTechLvlUse = minTechLvlUse;
        this.techWMostProd = techWMostProd;
        this.basePrice = basePrice;
        this.priceIncPerLvl = priceIncPerLvl;
        this.lowPriceCondition = lowPriceCondition;
        this.highPriceCondition = highPriceCondition;
    }

    public Good(int minTechLvlMk, int minTechLvlUse, int techWMostProd, int basePrice,
                int priceIncPerLvl, int variance, ResourceLevel lowPriceCondition) {
        this(minTechLvlMk, minTechLvlUse, techWMostProd, basePrice, priceIncPerLvl,
                variance, lowPriceCondition, ResourceLevel.NOSPECIALRESOURCES);
    }

    public Good(int minTechLvlMk, int minTechLvlUse, int techWMostProd, int basePrice,
                int priceIncPerLvl, int variance) {
        this(minTechLvlMk, minTechLvlUse, techWMostProd, basePrice, priceIncPerLvl,
                variance, ResourceLevel.NOSPECIALRESOURCES, ResourceLevel.NOSPECIALRESOURCES);
    }

}
