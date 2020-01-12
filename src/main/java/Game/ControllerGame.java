package Game;

import Player.ControllerPlayer;

public class ControllerGame {
    public void playGame() {
        ControllerGUI c_gui = new ControllerGUI();
        ControllerPlayer c_player = new ControllerPlayer();
        c_gui.changeBoardLanguage();
        c_player.createPlayerArray(c_gui.addPlayers(0));
    }
}