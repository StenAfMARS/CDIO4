package Chancecard;

public class ModelTaxCard extends ModelChanceCard {
    private int _pricePrHouse = 500;
    private int _pricePrHotel = 1000;

    public ModelTaxCard(int pricePrHouse, int pricePrHotel){
        _pricePrHouse = pricePrHouse;
        _pricePrHotel = pricePrHotel;
    }

    public int getPricePrHouse() {
        return _pricePrHouse;
    }

    public int getPricePrHotel() {
        return _pricePrHotel;
    }
}
