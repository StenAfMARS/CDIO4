package Game;

import gui_main.GUI;

public class ControllerGUI {
    private GUI _gui;
    public ControllerGUI(){
        _gui = new GUI();
    }
    public void addPlayer(){
        _gui.getUserString("");
    }
}
