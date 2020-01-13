package Chancecard;

public class ModelMoveCard extends ModelChanceCard {
    private int _amount;
    public ModelMoveCard(int amount){
        _amount = amount;
    }

    public int get_amount() {
        return _amount;
    }
}
