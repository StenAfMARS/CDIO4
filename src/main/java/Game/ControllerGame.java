package Game;

import Chancecard.ControllerChanceCard;
import Fields.ControllerField;
import Player.ControllerPlayer;

public class ControllerGame {
    private int _currentPlayer;
    private DiceCarrier diceCarrier = new DiceCarrier(2);

    private ControllerGUI c_gui = ControllerGUI.get();
    private ControllerPlayer c_player = ControllerPlayer.get();
    private ControllerField c_field = ControllerField.get();
    private ControllerChanceCard c_chanceCard = ControllerChanceCard.get();

    private ControllerGame(){

    }

    private static ControllerGame _instance;

    public static ControllerGame get()
    {
        if (_instance == null) {
            _instance = new ControllerGame();
        }
        return _instance;
    }

    private boolean won = false;

    /**
     * startGame() used to change board language, add players, add balance. All in GUI. Furthermore it runs the gameLoop() and endGame().
     */
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

    /**
     * gameloop() shuffles the chance cards.
     * It runs a while loop as longe as there is no winner. If a loser is found the turn is given onto the next player.
     * It runs the method doTurn() in the while loop as well.
     */
    private void gameLoop(){
        //Main game loop
        c_chanceCard.shuffle();
        while (!won) {
            if (!c_player.hasPlayerLost(currentPlayer()))
                doTurn();

            nextPlayer();
        }
    }

    /**
     * doTurn() runs the turn for a player.
     */
    private void doTurn() {
        //Start of turn
        c_gui.displayMessage("game.playersTurn", c_player.getPlayerName(currentPlayer()));

        c_gui.displayDieOnBoard(diceCarrier.rollDice());
        int lastPos = c_player.getPlayerPosition(currentPlayer());
        c_player.changePlayerPosition(currentPlayer(), diceCarrier.getDiceValueSum());

        if (c_player.isPlayerJailed(currentPlayer())) {
            c_player.changePlayerMoney(-1000, currentPlayer());
            c_player.setPlayerJailed(currentPlayer(), false);
            //Need to change 10 to be more flexible for jail on field
            c_gui.movePlayer(currentPlayer(),c_player.getPlayerPosition(currentPlayer()),10);
        }
        //Middle of turn
        c_field.landOnField(currentPlayer());
        if (c_field.ownedPropertyCount(currentPlayer()) != 0) {
            if (c_gui.getPlayerBoolean("game.manageProperties?", "yes", "no")) {
                c_field.manageProperty(currentPlayer());
            }
        }
        if (diceCarrier.get_diceFaces()[0] == diceCarrier.get_diceFaces()[1]) {
            doTurn();
            c_gui.displayMessage(c_player.getPlayerName(currentPlayer()) + "");
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

    /**
     * auction() used to create an auction for a field that the original player, whose turn it is, landed on.
     * The auction works with each player being asked if they want to bid higher than the player before. This continues until one of the players has the highest bid and the two others declines bidding higher.
     * @param fieldID ID of a given field.
     */
    public void auction(int fieldID) {
        int lastBidder = -1;
        int highestBid = c_field.getPropertyPrice(fieldID);

        int currentBidder = (currentPlayer() + 1) % c_player.playerCount();

        while (lastBidder != currentBidder && !(lastBidder==-1 && currentBidder==currentPlayer() )){
            if (!c_player.hasPlayerLost(currentBidder)) {
                if (c_gui.getPlayerBoolean("game.bid", "yes", "no", ControllerPlayer.get().getPlayerName(currentBidder), round((int)(highestBid * 1.1), 50))) {
                    highestBid = round((int)(highestBid * 1.1), 50);
                    lastBidder = currentBidder;
                }
            }

            currentBidder++;
            currentBidder %= c_player.playerCount();
        }

        if (lastBidder != -1) {
            c_field.setPropertyOwner(fieldID, lastBidder);
            c_player.changePlayerMoney(-highestBid, lastBidder);
        }
    }

    private int round(int number, int roundTo){
        return (Math.round(number / roundTo) * roundTo);
    }
}