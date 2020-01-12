package Game;

import Language.LanguageManager;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class ControllerGUI {
    private GUI _gui;
    private LanguageManager _lang;
    private GUI_Player[] _players;
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
        /*for (GUI_Field gf:_gui.getFields()) {
        }*/
    }

    /**
     * Method for adding players on the game board and getting player names
     * @param startBalance How much money all the players is starting with
     * @return A string array with all the player names
     */
    public String[] addPlayers(int startBalance){
        String[] names = new String[Integer.parseInt(_gui.getUserSelection(_lang.getString("gui.selectPlayerCount"),"3","4","5","6"))];
        _players = new GUI_Player[names.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = _gui.getUserString(_lang.getString("gui.selectPlayerName"));
            //No players with the same name
            for (int j = 0; j < i; j++) {
                if (names[i].equals(names[j])){
                    names[i] = names[j] + " ";
                }
            }
            _players[i] = new GUI_Player(names[i],startBalance);
            _gui.addPlayer(_players[i]);
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

    /**
     * Function to move player the player one field at a time. Can output error on GUI
     * @param playerID Which player to move
     * @param currentPosition Where the player currently is placed
     * @param newPosition The position the player has to move to
     */
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
    public void placeHouse(int fieldID, int currentAmountOfHouses){
        try{
            GUI_Street street = (GUI_Street) _gui.getFields()[fieldID];
            street.setHouses(currentAmountOfHouses + 1);
        } catch (Exception e){
            System.out.println("WARNING: ControllerGUI placeHouse() casting not successful. Object that got casted to street: " + _gui.getFields()[fieldID].getClass().getName());
        }
    }
    public void placeHouse(int fieldID, int currentAmountOfHouses, int amountOfHousesToPlace){
        try{
            GUI_Street street = (GUI_Street) _gui.getFields()[fieldID];
            street.setHouses(currentAmountOfHouses + 1);
        } catch (Exception e){
            System.out.println("WARNING: ControllerGUI placeHouse() casting not successful. Object that got casted to street: " + _gui.getFields()[fieldID].getClass().getName());
        }
    }
    public void removeHouses(int fieldID, int currentAmountOfHouses, int amountOfHousesToRemove){
        try{
            GUI_Street street = (GUI_Street) _gui.getFields()[fieldID];
            street.setHouses(currentAmountOfHouses - amountOfHousesToRemove);
        } catch (Exception e){
            System.out.println("WARNING: ControllerGUI removeHouse() casting not successful. Object that got casted to street: " + _gui.getFields()[fieldID].getClass().getName());
        }
    }
    public void placeHotel(int fieldID){
        try{
            GUI_Street street = (GUI_Street) _gui.getFields()[fieldID];
            street.setHotel(true);
        } catch (Exception e){
            System.out.println("WARNING: ControllerGUI placehotel() casting not successful. Object that got casted to street: " + _gui.getFields()[fieldID].getClass().getName());
        }
    }
    public void removeHotel(int fieldID){
        try{
            GUI_Street street = (GUI_Street) _gui.getFields()[fieldID];
            street.setHotel(false);
        } catch (Exception e){
            System.out.println("WARNING: ControllerGUI removeHotel() casting not successful. Object that got casted to street: " + _gui.getFields()[fieldID].getClass().getName());
        }
    }

    /**
     * Private sleep function
     * @param milliseconds How many milliseconds to sleep for
     * @throws InterruptedException Throws exception from Thread.sleep
     */
    private void sleep(long milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }
}
