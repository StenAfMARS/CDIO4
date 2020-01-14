package Game;

import Chancecard.ControllerChanceCard;
import Fields.ControllerField;
import Player.ControllerPlayer;

public class ControllerGame {
    private int _currentPlayer;
    private DiceCarrier diceCarrier = new DiceCarrier(2);
    private int[] playerPosition;

    private ControllerGUI c_gui = new ControllerGUI();
    private ControllerPlayer c_player = new ControllerPlayer();
    private ControllerField c_field = new ControllerField();
    ControllerChanceCard c_chanceCard = new ControllerChanceCard();

    private boolean won = false;

    public void startGame() {

        c_gui.changeBoardLanguage();
        c_player.createPlayerArray(c_gui.addPlayers(30000));
        //Place players on start
        for (int i = 0; i < c_player.playerCount(); i++) {
            c_gui.placePlayerOnStart(i);
            playerPosition[i] = 0;
        }

        gameLoop();
        endGame();
    }

    private void gameLoop(){
        //Main game loop
        while (!won) {
            if (!c_player.hasPlayerLost(currentPlayer()))
                doTurn();

            nextPlayer();
        }
    }

    private void doTurn() {

        if (c_gui.getPlayerBoolean("game.manageProperties?", "yes", "no")){
            manageProperty(currentPlayer());
        }
        c_gui.displayDieOnBoard(diceCarrier.rollDice());

        if (currentPlayer() + diceCarrier.getDiceValueSum() >= c_field.getFieldLength()) {
            c_gui.movePlayer(i, playerPositions[i], playerPositions[i] + diceCarrier.getDiceValueSum() - c_field.getFieldLength());
            playerPositions[i] = playerPositions[i] + diceCarrier.getDiceValueSum() - 1 - c_field.getFieldLength();
        } else {
            c_gui.movePlayer(i, playerPositions[i], diceCarrier.getDiceValueSum() + playerPositions[i]);
            playerPositions[i] += diceCarrier.getDiceValueSum();
        c_gui.movePlayer(currentPlayer(),playerPosition[currentPlayer()] ,diceCarrier.getDiceValueSum());
        playerPosition[currentPlayer()] += diceCarrier.getDiceValueSum();}

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
        if (c_gui.getPlayerBoolean("Do you want to build a house?", "Yes", "No")) {
        }
    }

    private void auction(int fieldID) {


    }

    public void LandOnChanceCard(String groupType, int playerID){

        switch (groupType){
            case"tax":
                //int tax = c_ChanceCard.calculateTax(c_player.);
                c_player.changeAmountOfMoney(1, playerID);
                break;
        }
    }
}