package Game;

import Player.ControllerPlayer;

public class ControllerGame {
    public void playGame(){
        ControllerGUI c_gui = new ControllerGUI();
        ControllerPlayer CP = new ControllerPlayer();
        CP.createPlayerArray(c_gui.addPlayers());
    }
}
