package Chancecard;

 class ModelChangeMoneyCard extends ModelChanceCard{
    private int _amount;

     /**
      * ModelChangeMoneyCard() used to make a model for the ChangeMoneyCard.
      * @param amount - amount of money.
      */
     ModelChangeMoneyCard(int amount){
        _amount = amount;
    }

     /**
      * get_amount(9
      * @return private attribut _amount. Amount of money.
      */
     int get_amount() {
        return _amount;
    }
}
