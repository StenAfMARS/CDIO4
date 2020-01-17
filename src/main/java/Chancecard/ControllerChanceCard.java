package Chancecard;

import Fields.ControllerField;
import Game.ControllerGUI;
import Language.LanguageManager;
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
                new ModelChangeMoneyCard(12,100),
                new ModelChangeMoneyCard(13,500),
                new ModelChangeMoneyCard(14,1000),
                new ModelChangeMoneyCard(2,-500),
                new ModelChangeMoneyCard(15,1500),
                new ModelChangeMoneyCard(11,-200),
                new ModelChangeMoneyCard(2,-2000),
                new ModelChangeMoneyCard(16,100),
                new ModelChangeMoneyCard(21,400),
                new ModelChangeMoneyCard(2,-150),
                new ModelChangeMoneyCard(22,100),
                new ModelChangeMoneyCard(2,-750),
                new ModelChangeMoneyCard(23,100),
                new ModelChangeMoneyCard(23,400),
                new ModelChangeMoneyCard(2,-750),
                new ModelChangeMoneyCard(23,1000),
                new ModelChangeMoneyCard(11,-50),
                new ModelChangeMoneyCard(21,300),
                new ModelChangeMoneyCard(22,150),
                new ModelChangeMoneyCard(21,800),
                new ModelChangeMoneyCard(11,-2750),
                new ModelMoveCard(31,5),
                new ModelMoveCard(32,-3),
                new ModelTaxCard(0,-500, -2000),
                new ModelTaxCard(1,-800, -2300),
                new ModelMoveTo(29,new int[]{5}),
                new ModelMoveTo(29,new int[]{8}),
                new ModelMoveTo(29,new int[]{1}),
                new ModelMoveTo(29,new int[]{4}),
                new ModelMoveTo(29,new int[]{8}),
                new ModelMoveTo(29,new int[]{4}),
                new ModelMoveTo(29,new int[]{2}),
                new ModelMoveTo(29,new int[]{9}),
                new ModelMoveTo(29,new int[]{1}),
                new ModelMoveTo(29,new int[]{7,17,27,37}),
                new ModelGoToJailCard(40),
                new ModelOutOfJailFreeCard(69)
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

             ControllerGUI.get().showChanceCard("chanceCard.description." + upper.get_iD(), Math.abs(card.get_amount()));
        }
        else if(upper instanceof ModelTaxCard){
            ModelTaxCard card = ((ModelTaxCard)upper);
            int tax = calculateTax(ControllerField.get().getHouseCount(playerID),ControllerField.get().getHotelCount(playerID));// TEMPT
            ControllerPlayer.get().changePlayerMoney(tax,playerID);
            ControllerGUI.get().showChanceCard("chanceCard.description." + upper.get_iD(), Math.abs(card.getPricePrHouse()),Math.abs(card.getPricePrHotel()));
        }
        else if(upper instanceof ModelMoveTo){
            ModelMoveTo card = ((ModelMoveTo)upper);
            int destination = card.get_destination()[0];

            ControllerGUI.get().showChanceCard("chanceCard.description." + upper.get_iD(), LanguageManager.get().getString(ControllerField.get().getFieldTitle(destination)));

            ControllerPlayer.get().setPlayerPosition(playerID,destination);
            ControllerField.get().landOnField(playerID);


        }
        else if(upper instanceof ModelGoToJailCard){
            ControllerPlayer.get().setPlayerJailed(playerID,true);
        }
        else if(upper instanceof ModelOutOfJailFreeCard){
            ControllerPlayer.get().setOutOfJailFree(playerID);
        }
        else if(upper instanceof ModelMoveCard){
            ModelMoveCard card = ((ModelMoveCard)upper);
            int moveToField = ControllerPlayer.get().getPlayerPosition(playerID)+card.get_amount();
            ControllerGUI.get().showChanceCard("chanceCard.description." + upper.get_iD(), Math.abs(card.get_amount()));
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
