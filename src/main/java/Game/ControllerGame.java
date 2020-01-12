package Game;

import Fields.ControllerField;
import Player.ControllerPlayer;

public class ControllerGame {
    public void playGame() {
        ControllerGUI c_gui = new ControllerGUI();
        ControllerPlayer c_player = new ControllerPlayer();
        ControllerField c_field = new ControllerField();

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
                int currentPlayerAccount = c_player.get_playerArray()[i].get_account().get_money();
                c_player.get_playerArray()[i].get_account().set_money(0);
                c_gui.updatePlayer(i,currentPlayerAccount);
                //Check if player has any fields that can have a house or hotel or has any houses or hotels
                //Ask if player wants to build or sell a house/hotel


                //Roll dice

                //Find field type

                //Do field action

                //Check if player lost as last action
                if (currentPlayerAccount <= 0){
                    return;
                }
            }
        }
    }
}