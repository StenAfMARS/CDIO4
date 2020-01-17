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

    /**
     * get() used to create a instance of ControllerGame.
     *
     * @return private attribute _instance. Which is a new ControllerGame().
     */
    public static ControllerGame get() {
        if (_instance == null) {
            _instance = new ControllerGame();
        }
        return _instance;
    }

    private boolean won = false;

    /**
     * startGame() used to changeBoardLanguage, add players and balance, in GUI. Furthermore it runs gameLoop() and endGame().
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
     * gameLoop() shuffles the chancecards.
     * Runs a while loop as long as there is no winner. If a loser is found it gives the turn to the next player.
     * It runs the method doturn() in the while loop as well.
     */
    private void gameLoop() {
        //Main game loop
        c_chanceCard.shuffle();
        while (!won) {
            if (!c_player.hasPlayerLost(currentPlayer()))
                doTurn();

            nextPlayer();
        }
    }

    /**
     * doTurn() runs the turn for a player. It displays who's turn it is in GUI. It displays the dices in GUI.
     * It changes the players positions in GUI. It updates the players amount of money in GUI.
     * It moves the player in system backend. It also ask the the player if they would like to manage their properties.
     */
    private void doTurn() {
        //Start of turn
        c_gui.displayMessage("game.playersTurn", c_player.getPlayerName(currentPlayer()));

        c_gui.displayDieOnBoard(diceCarrier.rollDice());
        c_player.changePlayerPosition(currentPlayer(), diceCarrier.getDiceValueSum());
        c_gui.updatePlayer(currentPlayer(), c_player.getPlayerMoney(currentPlayer()));
        //Middle of turn
        c_field.landOnField(currentPlayer());

        if (c_gui.getPlayerBoolean("game.manageProperties?", "yes", "no")) {
            manageProperty(currentPlayer());
        }

    }

    private void endGame() {

    }

    /**
     * nextPlayer() is used to
     *
     * @return private attribute _currentPlayer. Which is the next player whos turn it is.
     */
    private int nextPlayer() {
        _currentPlayer++;
        _currentPlayer %= c_player.playerCount();
        return _currentPlayer;
    }

    /**
     * currentPlayer is used to
     *
     * @return private attribute _currentPlayer(). The player whos turn it currently is.
     */
    private int currentPlayer() {
        return _currentPlayer;
    }

    /**
     * manageProperty() used to ask if the player wants to build a house.
     *
     * @param playerID ID of a player.
     */
    private void manageProperty(int playerID) {
        if (c_gui.getPlayerBoolean("question.buildHouse", "Yes", "No")) {
        }
    }

    /**
     * auction() used to create an auction for a field that the original player, whos turn turn it is, landed on.
     * The auction works with each player being asked if they want to bid higher. This continues until one of the players has the highest bid,
     * and the two other declines bidding higher.
     *
     * @param fieldID ID of a given field.
     */
    public void auction(int fieldID) {
        int lastBidder = -1;
        int highestBid = c_field.getPropertyPrice(fieldID);

        int currentBidder = (currentPlayer() + 1) % c_player.playerCount();

        while (lastBidder != currentBidder && !(lastBidder == -1 && currentBidder == currentPlayer())) {
            if (!c_player.hasPlayerLost(currentBidder)) {
                if (c_gui.getPlayerBoolean("game.bid", "yes", "no", ControllerPlayer.get().getPlayerName(currentBidder), round((int) (highestBid * 1.1), 50))) {
                    highestBid = round((int) (highestBid * 1.1), 50);
                    lastBidder = currentBidder;
                }
            }

            currentBidder++;
            currentBidder %= c_player.playerCount();
        }

        if (lastBidder != -1) {
            c_field.setPropertyOwner(fieldID, lastBidder);
            c_player.setPlayerMoney(-highestBid, lastBidder);
        }
    }

    /**
     * round() used to create round.     *
     * @param number
     * @param roundTo
     * @return (Math.round(number / roundTo) * roundTo) as an integer.
     */
    private int round(int number, int roundTo) {
        return (Math.round(number / roundTo) * roundTo);
    }
}