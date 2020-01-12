package Game;

import Fields.ControllerField;
import Player.ControllerPlayer;

public class ControllerGame {
    public void playGame() {
        ControllerGUI c_gui = new ControllerGUI();
        ControllerPlayer c_player = new ControllerPlayer();
        ControllerField c_field = new ControllerField();

        c_gui.changeBoardLanguage();
        c_player.createPlayerArray(c_gui.addPlayers());
        ControllerPlayer c_player = new ControllerPlayer();
        c_gui.changeBoardLanguage();
        c_player.createPlayerArray(c_gui.addPlayers(0));
    }
}