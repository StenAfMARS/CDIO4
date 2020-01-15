package Chancecard;

 class ModelChangeMoneyCard extends ModelChanceCard{
    private int _amount;
     ModelChangeMoneyCard(int amount){
        _amount = amount;
    }

     int get_amount() {
        return _amount;
    }
}
