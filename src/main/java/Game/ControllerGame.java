package Game;

import Chancecard.ControllerChanceCard;
import Fields.ControllerField;
import Player.ControllerPlayer;

public class ControllerGame {
    private int _currentPlayer;

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
                System.out.println(c_chanceCard.draw());
            nextPlayer();
        }
    }

    private void doTurn() {

        if (c_gui.getPlayerBoolean("game.manageProperties?", "yes", "no")){
            manageProperty(currentPlayer());
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
        if (c_gui.getPlayerBoolean("Do you want to build a house?", "Yes", "No")) {
        }
    }

    private void auction(int fieldID) {


    }

    public void LandOnChanceCard(String groupType, int playerID){
        switch (groupType){
            case"moneychange":
                c_player.changeAmountOfMoney();
                break;
            case"movePlayerFields":
                int currentPlayerPosition = 1;
                c_gui.movePlayer(playerID,currentPlayerPosition,6);// TEMP

                break;
            case"tax":
                int tax = c_chanceCard.calculateTax(4,6);
                c_player.changeAmountOfMoney(tax, playerID);
                break;
        }
    }
}