package Chancecard;

 class ModelChangeMoneyCard extends ModelChanceCard{
    private int _amount;
     ModelChangeMoneyCard(int iD,int amount){
         super(iD);
        _amount = amount;
    }

     int get_amount() {
        return _amount;
    }
}
