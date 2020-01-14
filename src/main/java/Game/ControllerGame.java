package Game;

import Fields.ControllerField;
import Player.ControllerPlayer;
import Chancecard.ControllerChanceCard;
public class ControllerGame {
    ControllerGUI c_gui = new ControllerGUI();
    ControllerPlayer c_player = new ControllerPlayer();
    ControllerField c_field = new ControllerField();

    public void playGame() {


        c_gui.changeBoardLanguage();
        c_player.createPlayerArray(c_gui.addPlayers(30000));

        boolean won = false;
        int[] playerPositions = new int[c_player.get_playerArray().length];

        //Place players on start
        for (int i = 0; i < c_player.get_playerArray().length; i++) {
            c_gui.placePlayerOnStart(i);
            playerPositions[i] = 0;
        }
        //Main game loop
        while (!won){
            //Main turn loop
            for (int i = 0; i < c_player.get_playerArray().length; i++) {
                //c_player.get_playerArray()[i].get_account().set_money(0);
                //c_gui.updatePlayer(i,c_player.get_playerArray()[i].get_account().get_money());


                //Check if player has any fields that can have a house or hotel or has any houses or hotels
                //Ask if player wants to build or sell a house/hotel
                if (c_gui.getPlayerBoolean("Do you want to build a house?","Yes","No")){
                }
                c_gui.movePlayer(i,0,i);

                //Roll dice

                //Find field type

                //Do field action

                //Check if player lost as last action
                if (c_player.get_playerArray()[i].get_account().get_money() < 0){
                    return;
                }
            }
            return;
        }
    }
    public void LandOnChanceCard(String groupType,int playerID){
        ControllerChanceCard c_ChanceCard = new ControllerChanceCard();

        switch (groupType){
            case"tax":
                //int tax = c_ChanceCard.calculateTax(c_player.);
                c_player.changeAmountOfMoney(1, playerID);
                break;
        }
    }
}