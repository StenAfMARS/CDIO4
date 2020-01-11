package Game;

import Language.LanguageManager;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class ControllerGUI {
    private GUI _gui;

    public ControllerGUI(){
        _gui = new GUI();
    }

    public void changeBoardLanguage(String newLanguage){
        LanguageManager.get().setLanguage(newLanguage);
        for (GUI_Field gf:_gui.getFields()) {
        }
    }

    public String[] addPlayers(){
        String[] names = new String[Integer.parseInt(_gui.getUserSelection("Select amount of players","3","4","5","6"))];
        for (int i = 0; i < names.length; i++) {
            names[i] = _gui.getUserString("Select player");
            _gui.addPlayer(new GUI_Player(names[i],0));
        }
        return names;
    }

    public void displayDieOnBoard(int faceValue[]){
        _gui.setDice(faceValue[0],faceValue[1]);
    }
}
