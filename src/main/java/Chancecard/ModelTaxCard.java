package Chancecard;

 class ModelTaxCard extends ModelChanceCard {
    private int _pricePrHouse;
    private int _pricePrHotel;

     ModelTaxCard(int pricePrHouse, int pricePrHotel){
        _pricePrHouse = pricePrHouse;
        _pricePrHotel = pricePrHotel;
    }

     int getPricePrHouse() {
        return _pricePrHouse;
    }

     int getPricePrHotel() {
        return _pricePrHotel;
    }
}
