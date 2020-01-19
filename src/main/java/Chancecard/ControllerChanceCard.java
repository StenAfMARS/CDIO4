package Chancecard;

import Fields.ControllerField;
import Game.ControllerGUI;
import Language.LanguageManager;
import Player.ControllerPlayer;
public class ControllerChanceCard {
    private ModelChanceCard[] _chanceCards;

    private static ControllerChanceCard _instance;

    /**
     * get() used to
     * @return _private attribute _instance. The instance of a new ControllerChanceCard
     */
    public static ControllerChanceCard get()
    {
        // her constructor jeg classen
        if (_instance == null) {
            _instance = new ControllerChanceCard();
        }
        return _instance;
    }

    /**
     * ControllerChanceCard used to make the different models of chance cards in an array.
     */
    private ControllerChanceCard(){
        // her fylder jeg et array op med opbjector
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

    /**
     * swap() used for swapping ownable chance cards.
     * @param a chancecard a.
     * @param b chancecard b.
     */
    private void swap(int a, int b){
        // her fortæller jeg hvordan jeg vil have den til at blande mit deck
        ModelChanceCard cardA = _chanceCards[a];
        ModelChanceCard cardB = _chanceCards[b];
        _chanceCards[a] = cardB;
        _chanceCards[b] = cardA;
    }

    /**
     * shuffle() used to shuffle the deck of chance cards.
     */
    public void shuffle(){
        // her blander jeg mit deck 300000 gange
        for (int i=0; i<30000; i++ ){
            int a= (int) (Math.random()*_chanceCards.length);
            int b= (int) (Math.random()*_chanceCards.length);
            swap(a,b);
        }
    }

    /**
     * draw() used for drawing chance cards. Checks which type of chance card is drawn, and does the consequence of the given card.
     * @param playerID ID of a player.
     * @return upper. The card on top of the deck.
     */
    public ModelChanceCard draw(int playerID){
        //her trækker man det øverste kort
        ModelChanceCard upper= _chanceCards[0];
        for (int i=0; i<_chanceCards.length-1;i++){
            _chanceCards[i] =_chanceCards [i+1];
        }
        // her gør jeg decket 1 mindre
        _chanceCards[_chanceCards.length-1]=upper;
        // her fortæller jeg hvad koden skal gører hvis kortet er af typen modelChangeMoneyCard
        if (upper instanceof ModelChangeMoneyCard) {
             ModelChangeMoneyCard card = ((ModelChangeMoneyCard)upper);
             // her ændre jeg spillerens penge beholdning
             ControllerPlayer.get().changePlayerMoney(card.get_amount(),playerID);
            // her fortæller jeg hvad guin skal sige til spilleren
             ControllerGUI.get().showChanceCard("chanceCard.description." + upper.get_iD(), Math.abs(card.get_amount()));
        }
        // her fortæller jeg hvad programmen skal gøre hvis det er tax kort
        else if(upper instanceof ModelTaxCard){
            ModelTaxCard card = ((ModelTaxCard)upper);
            // her beder jeg om at beregne skatten
            int tax = calculateTax(ControllerField.get().getHouseCount(playerID),ControllerField.get().getHotelCount(playerID));// TEMPT
            // her ændre jeg spillerens penge
            ControllerPlayer.get().changePlayerMoney(tax,playerID);
            // her fortæller jeg hvad guien skal sige til spilleren
            ControllerGUI.get().showChanceCard("chanceCard.description." + upper.get_iD(), Math.abs(card.getPricePrHouse()),Math.abs(card.getPricePrHotel()));
        }
        // her siger jeg hvad koden skal gøre hvis kortet er Move to
        else if(upper instanceof ModelMoveTo){
            ModelMoveTo card = ((ModelMoveTo)upper);
            // her hendter jeg kortet destination
            int destination = card.get_destination()[0];
            // her siger jeg til guien hvad den skal sige til spilleren
            ControllerGUI.get().showChanceCard("chanceCard.description." + upper.get_iD(), LanguageManager.get().getString(ControllerField.get().getFieldTitle(destination)));
            // her ændre jeg spilleresn position
            ControllerPlayer.get().setPlayerPosition(playerID,destination);
            // her beder jeg den om køre en funktion landOnField der fortæller programmen hvad der skal ske på de forskellige felter
            ControllerField.get().landOnField(playerID);


        }
        // her fortæller jeg koden hvad skal gører hvis kortet er en ModelGoToJailCard
        else if(upper instanceof ModelGoToJailCard){
            // ryk i fængsel
            ControllerPlayer.get().setPlayerJailed(playerID,true);
        }

        else if(upper instanceof ModelOutOfJailFreeCard){
            // her for du et kort der kan få dig ud af fængsel

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

    /**
     * calculateTax() used for calculating the tax a player has to pay when drawing a specific chance card.
     * @param amountOfHouses amount of houses.
     * @param amountOfHotel amount of hotels.
     * @return tax as an int. The tax for houses and hotels.
     */
    // her beregnes skatten
    public int calculateTax(int amountOfHouses,int amountOfHotel){
        int tax;
        tax = 500*amountOfHouses + 1000*amountOfHotel;
        return tax;
    }


}
