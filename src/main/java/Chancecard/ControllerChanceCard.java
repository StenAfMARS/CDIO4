package Chancecard;

public class ControllerChanceCard {
    private ModelChanceCard[] _chanceCards;

    public ControllerChanceCard(){
        _chanceCards = new ModelChanceCard[]{
                new ModelChangeMoneyCard(100),
                new ModelChangeMoneyCard(500),
                new ModelChangeMoneyCard(1000),
                new ModelChangeMoneyCard(-500),
                new ModelChangeMoneyCard(1500),
                new ModelChangeMoneyCard(-200),
                new ModelChangeMoneyCard(-2000),
                new ModelChangeMoneyCard(100),
                new ModelChangeMoneyCard(400),
                new ModelChangeMoneyCard(-150),
                new ModelChangeMoneyCard(100),
                new ModelChangeMoneyCard(-750),
                new ModelChangeMoneyCard(100),
                new ModelChangeMoneyCard(400),
                new ModelChangeMoneyCard(-750),
                new ModelChangeMoneyCard(1000),
                new ModelChangeMoneyCard(-50),
                new ModelChangeMoneyCard(300),
                new ModelChangeMoneyCard(150),
                new ModelChangeMoneyCard(800),
                new ModelChangeMoneyCard(-2750),
                new ModelMoveCard(5),
                new ModelMoveCard(3),
                new ModelTaxCard(500, 1000),
                new ModelTaxCard(500, 1000),
                new ModelMoveTo(new int[]{5}),
                new ModelMoveTo(new int[]{8}),
                new ModelMoveTo(new int[]{1}),
                new ModelMoveTo(new int[]{4}),
                new ModelMoveTo(new int[]{8}),
                new ModelMoveTo(new int[]{4}),
                new ModelMoveTo(new int[]{2}),
                new ModelMoveTo(new int[]{9}),
                new ModelMoveTo(new int[]{1}),
                new ModelMoveTo(new int[]{7,17,27,37})
        };
    }
}
