package Chancecard;

 class ModelMoveCard extends ModelChanceCard {
    private int _amount;
     ModelMoveCard(int iD, int amount) {
         super(iD);
        _amount = amount;
    }

     int get_amount() {
        return _amount;
    }
}
