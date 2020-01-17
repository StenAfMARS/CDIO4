package Chancecard;

 class ModelTaxCard extends ModelChanceCard {
    private int _pricePrHouse;
    private int _pricePrHotel;

     /**
      * ModelTaxCard() used to make a model for the chance card of the type TaxCard.
      * @param pricePrHouse tax price per house.
      * @param pricePrHotel tax price per hotel.
      */
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
