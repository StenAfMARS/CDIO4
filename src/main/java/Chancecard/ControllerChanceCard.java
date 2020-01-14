package Chancecard;

import Chancecard.ModelTaxCard;
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
                new ModelTaxCard(-500, -2000),
                new ModelTaxCard(-800, -2300),
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
    public void swap(int a, int b){
        ModelChanceCard cardA = _chanceCards[a];
        ModelChanceCard cardB = _chanceCards[b];
        _chanceCards[a] = cardB;
        _chanceCards[b] = cardA;
    }

    public void shuffle(){
        for (int i=0; i<1000; i++ ){
            int a= (int) (Math.random()*_chanceCards.length);
            int b= (int) (Math.random()*_chanceCards.length);
            swap(a,b);
        }
    }

    public ModelChanceCard draw(){
        ModelChanceCard upper= _chanceCards[0];
        for (int i=0; i<_chanceCards.length-1;i++){
            _chanceCards[i] =_chanceCards [i+1];
        }
        _chanceCards[_chanceCards.length-1]=upper;
        return upper;
    }

    public ModelChanceCard[] getChanceCards() {
        return _chanceCards;
    }
    public int calculateTax(int amountOfHouses,int pricePrHouse,int amountOfHotel,int pricePrHotel){
        ModelTaxCard mtc = new ModelTaxCard(pricePrHouse,pricePrHotel);
        int tax;
        tax = mtc.getPricePrHouse()*amountOfHouses + mtc.getPricePrHotel()*amountOfHotel;
        return tax;
    }

}
