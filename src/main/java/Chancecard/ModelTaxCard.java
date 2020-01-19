package Chancecard;

 class ModelTaxCard extends ModelChanceCard {
    private int _pricePrHouse;
    private int _pricePrHotel;

     ModelTaxCard(int iD,int pricePrHouse, int pricePrHotel){
         super(iD);
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
