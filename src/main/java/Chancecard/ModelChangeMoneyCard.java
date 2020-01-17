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
      * get_amount() used to
      * @return private attribut _amount.
      */
     int get_amount() {
        return _amount;
    }
}
