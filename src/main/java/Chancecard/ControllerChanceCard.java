package Chancecard;

import Fields.ControllerField;
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
                new ModelChangeMoneyCard(1,100),
                new ModelChangeMoneyCard(2,500),
                new ModelChangeMoneyCard(3,1000),
                new ModelChangeMoneyCard(4,-500),
                new ModelChangeMoneyCard(5,1500),
                new ModelChangeMoneyCard(6,-200),
                new ModelChangeMoneyCard(7,-2000),
                new ModelChangeMoneyCard(8,100),
                new ModelChangeMoneyCard(9,400),
                new ModelChangeMoneyCard(10,-150),
                new ModelChangeMoneyCard(11,100),
                new ModelChangeMoneyCard(12,-750),
                new ModelChangeMoneyCard(13,100),
                new ModelChangeMoneyCard(14,400),
                new ModelChangeMoneyCard(15,-750),
                new ModelChangeMoneyCard(16,1000),
                new ModelChangeMoneyCard(17,-50),
                new ModelChangeMoneyCard(18,300),
                new ModelChangeMoneyCard(19,150),
                new ModelChangeMoneyCard(20,800),
                new ModelChangeMoneyCard(21,-2750),
                new ModelMoveCard(22,5),
                new ModelMoveCard(23,3),
                new ModelTaxCard(24,-500, -2000),
                new ModelTaxCard(25,-800, -2300),
                new ModelMoveTo(26,new int[]{5}),
                new ModelMoveTo(27,new int[]{8}),
                new ModelMoveTo(28,new int[]{1}),
                new ModelMoveTo(29,new int[]{4}),
                new ModelMoveTo(30,new int[]{8}),
                new ModelMoveTo(31,new int[]{4}),
                new ModelMoveTo(32,new int[]{2}),
                new ModelMoveTo(33,new int[]{9}),
                new ModelMoveTo(34,new int[]{1}),
                new ModelMoveTo(35,new int[]{7,17,27,37})
        };
    }
    private void swap(int a, int b){
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
             ModelChangeMoneyCard card = ((ModelChangeMoneyCard)upper);
             ControllerPlayer.get().changePlayerMoney(card.get_amount(),playerID);
        }
        else if(upper instanceof ModelTaxCard){
            ModelTaxCard card = ((ModelTaxCard)upper);
            int tax = calculateTax(ControllerField.get().getHouseCount(playerID),ControllerField.get().getHotelCount(playerID));// TEMPT
            ControllerPlayer.get().changePlayerMoney(tax,playerID);
        }
        else if(upper instanceof ModelMoveTo){
            ModelMoveTo card = ((ModelMoveTo)upper);
            ControllerPlayer.get().setPlayerPosition(playerID,card.get_destination()[0]);
            ControllerField.get().landOnField(playerID);
        }
        else if(upper instanceof ModelMoveCard){
            ModelMoveCard card = ((ModelMoveCard)upper);
            int moveToField = ControllerPlayer.get().getPlayerPosition(playerID)+card.get_amount();
            ControllerPlayer.get().setPlayerPosition(playerID,moveToField);
            ControllerField.get().landOnField(playerID);
        }

        return upper;
    }


    public int calculateTax(int amountOfHouses,int amountOfHotel){
        int tax;
        tax = 500*amountOfHouses + 1000*amountOfHotel;
        return tax;
    }


}
