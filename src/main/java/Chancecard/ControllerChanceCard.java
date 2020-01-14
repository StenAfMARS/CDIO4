package Chancecard;

import Chancecard.ModelTaxCard;
import Fields.ControllerField;
import Game.ControllerGUI;
import Player.ControllerPlayer;
public class ControllerChanceCard {
    private ModelChanceCard[] _chanceCards;

    private static ControllerChanceCard _instance;

    public static ControllerChanceCard get()
    {
        if (_instance == null) {
            _instance = new ControllerChanceCard();
        }
        return _instance;
    }

    private ControllerChanceCard(){
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
        for (int i=0; i<30000; i++ ){
            int a= (int) (Math.random()*_chanceCards.length);
            int b= (int) (Math.random()*_chanceCards.length);
            swap(a,b);
        }
    }

    public ModelChanceCard draw(int playerID){

        ModelChanceCard upper= _chanceCards[0];
        for (int i=0; i<_chanceCards.length-1;i++){
            _chanceCards[i] =_chanceCards [i+1];
        }
        _chanceCards[_chanceCards.length-1]=upper;
        if (upper instanceof ModelChangeMoneyCard) {
             ModelChangeMoneyCard i = ((ModelChangeMoneyCard)upper);
            ControllerPlayer.get().changeAmountOfMoney(i.get_amount(),playerID);
        }
        else if(upper instanceof ModelTaxCard){
            int tax = calculateTax(3,3);// TEMPT
            ControllerPlayer.get().changeAmountOfMoney(tax,playerID);
        }
        else if(upper instanceof ModelMoveTo){
            ModelMoveTo i = ((ModelMoveTo)upper);
            ControllerGUI.get().movePlayer(playerID,ControllerPlayer.get().getPlayerPosition(playerID),i.get_destination()[0]);
        }
        else if(upper instanceof ModelMoveCard){
            ModelMoveCard i = ((ModelMoveCard)upper);
            int moveToField = ControllerPlayer.get().getPlayerPosition(playerID)+i.get_amount();
            ControllerGUI.get().movePlayer(playerID,ControllerPlayer.get().getPlayerPosition(playerID),moveToField);
        }

        return upper;
    }

    public ModelChanceCard[] get_chanceCards() {
        return _chanceCards;
    }

    public ModelChanceCard[] getChanceCards() {
        return _chanceCards;
    }
    public int calculateTax(int amountOfHouses,int amountOfHotel){
        int tax;
        tax = 500*amountOfHouses + 1000*amountOfHotel;
        return tax;
    }


}
