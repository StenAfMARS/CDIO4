package Game;

import Language.LanguageManager;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class ControllerGUI {
    private GUI _gui;
    private LanguageManager _lang = LanguageManager.get();
    private GUI_Player[] _players;
    public ControllerGUI(){
        _gui = new GUI();
    }

    public void changeBoardLanguage(String newLanguage){
        _lang.setLanguage(newLanguage);
        for (int i = 0; i < _gui.getFields().length; i++) {
            //Start field
            if (i == 0){
            }
            //Chance field
            else if(i == 2 || i == 7 || i == 17 || i == 22 || i == 33 || i == 36){
            }
            //Park or Visit Jail
            else if (i == 10 || i == 20){

            }
            //Go to jail
            else if (i == 30){

            }
        }
    }
    public void changeBoardLanguage(){
        _lang.setLanguage(_gui.getUserSelection(_lang.getString("selectLanguage"),_lang.getLanguages()));
    }

    public String[] addPlayers(int startBalance){
        String[] names = new String[Integer.parseInt(_gui.getUserSelection(_lang.getString("selectPlayerCount"),"3","4","5","6"))];
        _players = new GUI_Player[names.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = _gui.getUserString(_lang.getString("selectPlayerName"));
            _players[i] = new GUI_Player(names[i],startBalance);
            _gui.addPlayer(_players[i]);
        }
        return names;
    }

    public void displayDieOnBoard(int[] faceValue){
        _gui.setDice(faceValue[0],faceValue[1]);
    }

    public void movePlayer(int playerID, int currentPosition, int newPosition){
        for (int i = currentPosition; i < newPosition; i++) {
            _gui.getFields()[i].setCar(_players[playerID],false);
            _gui.getFields()[i+1].setCar(_players[playerID],true);
            try {
                sleep(100);
            } catch (InterruptedException e){
                _gui.showMessage("An error occurred");
            }
        }
    }
    private void sleep(long miliseconds) throws InterruptedException {
        Thread.sleep(miliseconds);
    }
}
