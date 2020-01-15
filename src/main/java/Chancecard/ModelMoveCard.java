package Chancecard;

 class ModelMoveCard extends ModelChanceCard {
    private int _amount;
     ModelMoveCard(int amount){
        _amount = amount;
    }

     int get_amount() {
        return _amount;
    }
}
