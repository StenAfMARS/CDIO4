package Chancecard;

 class ModelChangeMoneyCard extends ModelChanceCard{
    private int _amount;

     /**
      * ModelChangeMoneyCard() a constructor used for making a model of a chance money card.
      * @param iD the ID of a chance card.
      * @param amount the amount of money.
      */
     ModelChangeMoneyCard(int iD,int amount){
         super(iD);
        _amount = amount;
    }

     /**
      * get_amount() used for getting the amount of money.
      * @return private attribute _amount. The amount of money.
      */
     int get_amount() {
        return _amount;
    }
}
