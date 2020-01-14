package Chancecard;

public class ModelChangeMoneyCard extends ModelChanceCard{
    private int _amount;
    public ModelChangeMoneyCard(int amount){
        _amount = amount;
    }

    public int get_amount() {
        return _amount;
    }
}
