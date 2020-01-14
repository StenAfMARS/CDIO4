package Game;

import Chancecard.ControllerChanceCard;
import Fields.ControllerField;
import Player.ControllerPlayer;

public class ControllerGame {
    private int _currentPlayer;
    private DiceCarrier diceCarrier = new DiceCarrier(2);
    private int[] playerPosition;

    private ControllerGUI c_gui = ControllerGUI.get();
    private ControllerPlayer c_player = ControllerPlayer.get();
    private ControllerField c_field = ControllerField.get();
    private ControllerChanceCard c_chanceCard = ControllerChanceCard.get();

    private static ControllerGame _instance;

    public static ControllerGame get()
    {
        if (_instance == null) {
            _instance = new ControllerGame();
        }
        return _instance;
    }

    private boolean won = false;

    public void startGame() {
        c_gui.changeBoardLanguage();
        c_player.createPlayerArray(c_gui.addPlayers(30000));
        //Place players on start
        for (int i = 0; i < c_player.playerCount(); i++) {
            c_gui.placePlayerOnStart(i);
        }


        gameLoop();
        endGame();
    }

    private void gameLoop(){
        //Main game loop
        c_chanceCard.shuffle();
        while (!won) {
            if (!c_player.hasPlayerLost(currentPlayer()))
                doTurn();

            nextPlayer();
        }
    }

    private void doTurn() {
        //Start of turn

        c_gui.displayDieOnBoard(diceCarrier.rollDice());
        c_gui.movePlayer(currentPlayer(),c_player.getPlayerPosition(currentPlayer()),diceCarrier.getDiceValueSum() + c_player.getPlayerPosition(currentPlayer()));
        c_player.updatePlayerPosition(currentPlayer(),diceCarrier.getDiceValueSum());

        //Middle of turn
        c_field.landOnField(currentPlayer());

        for (int i = 0; i < c_player.playerCount(); i++) {
            c_gui.updatePlayer(i, c_player.getPlayerMoney(i));
        }

        if (c_gui.getPlayerBoolean("game.manageProperties?", "yes", "no")){
            manageProperty(currentPlayer());
        }

    }

    private void endGame(){

    }

    private int nextPlayer(){
        _currentPlayer++;
        _currentPlayer %= c_player.playerCount();
        return _currentPlayer;
    }

    private int currentPlayer() {
        return _currentPlayer;
    }

    private void manageProperty(int playerID){
        if (c_gui.getPlayerBoolean("question.buildHouse", "Yes", "No")) {
        }
    }

    public void auction(int fieldID) {
        int lastBidder = -1;
        int highestBid = c_field.getPropertyPrice(fieldID);

        int currentBidder = (currentPlayer() + 1) % c_player.playerCount();

        while (lastBidder != currentBidder && !(lastBidder==-1 && currentBidder==currentPlayer())){
            if (!c_player.hasPlayerLost(currentBidder)) {
                if (c_gui.getPlayerBoolean("game.bid", "yes", "no")) {
                    highestBid += round((int)(highestBid * 1.1), 50);
                    lastBidder = currentBidder;
                }
            }

            currentBidder++;
            currentBidder %= c_player.playerCount();
        }

        if (lastBidder != -1) {
            c_field.setPropertyOwner(fieldID, lastBidder);
            c_player.changeAmountOfMoney(highestBid, lastBidder);
        }
    }

    private int round(int number, int roundTo){
        return (Math.round(number / roundTo) * roundTo);
    }




}