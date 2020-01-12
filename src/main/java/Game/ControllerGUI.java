package Game;

import Language.LanguageManager;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class ControllerGUI {
    private GUI _gui;
    private LanguageManager _lang;

    public ControllerGUI(){
        _gui = new GUI();
        _lang = LanguageManager.get();
    }

    /**
     * Allows the players to choose the language of the game
     */
    public void changeBoardLanguage(){
        changeBoardLanguage(_gui.getUserSelection(_lang.getString("gui.chooseLanguage"), _lang.getLanguages()));
    }

    /**
     * Changes the language of the game
     * @param newLanguage the new language of the game
     */
    public void changeBoardLanguage(String newLanguage){
        for (String language:_lang.getLanguages()) {
            if (language.equalsIgnoreCase(newLanguage)){
                _lang.setLanguage(language);
                break;
            }
        }

        updateBoardLanguage();
    }

    /**
     * Updates all text on the board to match the current language.
     */
    public void updateBoardLanguage(){
        for (GUI_Field gf:_gui.getFields()) {
        }
    }

    /**
     * Let's the players choose how many they are and ask for a name from each of them
     * @return An array of player names
     */
    public String[] addPlayers(){
        String[] names = new String[Integer.parseInt(_gui.getUserSelection(_lang.getString("gui.selectPlayerAmount"),"3","4","5","6"))];
        for (int i = 0; i < names.length; i++) {
            names[i] = _gui.getUserString(_lang.getString("gui.selectPlayerName"));
            _gui.addPlayer(new GUI_Player(names[i],0));
        }
        return names;
    }

    /**
     * Displays dice on the board
     * @param faceValue
     */
    public void displayDieOnBoard(int faceValue[]){
        if (faceValue.length != 2) {
            System.out.println("WARNING: Wrong array size in ControllerGUI.displayDieOnBoard. Array size was: " + faceValue.length + "should be 2");
            return;
        }

        _gui.setDice(faceValue[0],faceValue[1]);
    }
}
