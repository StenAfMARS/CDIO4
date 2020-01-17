package Chancecard;

 class ModelMoveCard extends ModelChanceCard {
    private int _amount;

     /**
      * ModelMoveCard() used to make a model for the chance card type where you have to move your car.
      * @param amount
      */
     ModelMoveCard(int amount){
        _amount = amount;
    }

     /**
      * get_amount() used to
      * @return private attribute _amount.
      */
     int get_amount() {
        return _amount;
    }
}
