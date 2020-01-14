package Game;

import Fields.ControllerField;
import Language.LanguageManager;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class ControllerGUI {
    private GUI _gui;
    private LanguageManager _lang;
    private GUI_Player[] _players;
    private Color[] _ownedCarColors;

    private ControllerField c_field = ControllerField.get();

    private static ControllerGUI _instance;

    public static ControllerGUI get()
    {
        if (_instance == null) {
            _instance = new ControllerGUI();
        }
        return _instance;
    }

    private ControllerGUI(){
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
        for (int i = 0; i < _gui.getFields().length; i++) {
            _gui.getFields()[i].setTitle(_lang.getString(c_field.getFieldTitle(i)));
            _gui.getFields()[i].setDescription(_lang.getString(c_field.getFieldDescription(i)));
            _gui.getFields()[i].setSubText(_lang.getString(c_field.getFieldSubtext(i), c_field.getPropertyPrice(i)));
        }
    }

    //Is it better to return a reference to _gui instead of this?
    public boolean getPlayerBoolean(String question){
        return _gui.getUserLeftButtonPressed(_lang.getString(question),_lang.getString("yes"),_lang.getString("no"));
    }
    public boolean getPlayerBoolean(String question, String yesOption, String noOption){
        return _gui.getUserLeftButtonPressed(_lang.getString(question),_lang.getString(yesOption),_lang.getString(noOption));
    }

    public int getPlayerInt(String question){
        return _gui.getUserInteger(_lang.getString(question));
    }

    public int getPlayerInt(String question,int minValue, int maxValue){
        return _gui.getUserInteger(_lang.getString(question),minValue,maxValue);
    }

    public void displayMessage(String message){
        _gui.showMessage(_lang.getString(message));
    }
    public void displayMessage(String message, Object... args){
        _gui.showMessage(_lang.getString(message, args));
    }

    /**
     * This functions updates the player account on GUI
     * @param playerID Which player
     * @param money New balance
     */
    public void updatePlayer(int playerID, int money){
        _players[playerID].setBalance(money);
    }

    /**
     * Method for adding players on the game board and getting player names
     * @param startBalance How much money all the players is starting with
     * @return A string array with all the player names
     */
    public String[] addPlayers(int startBalance){
        String[] names = new String[Integer.parseInt(_gui.getUserSelection(_lang.getString("gui.selectPlayerCount"),"3","4","5","6"))];
        _players = new GUI_Player[names.length];
        _ownedCarColors = new Color[names.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = _gui.getUserString(_lang.getString("gui.selectPlayerName"));
            //No players with the same name
            for (int j = 0; j < i; j++) {
                if (names[i].equals(names[j])){
                    names[i] = names[j] + " ";
                }
            }
            _players[i] = new GUI_Player(names[i],startBalance,createCar(i));
            _gui.addPlayer(_players[i]);
        }
        return names;
    }

    /**
     * Create a unique color for the car
     * @param playerID which player the car belongs too
     * @return Returns a car with a unique color
     */
    private GUI_Car createCar(int playerID) {
        GUI_Car car = new GUI_Car();
        for (int i = 0; i < playerID; i++) {
            if (car.getPrimaryColor() == _ownedCarColors[i] && car.getPrimaryColor() == Color.WHITE)
                car = createCar(playerID);
        }
        _ownedCarColors[playerID] = car.getPrimaryColor();
        return car;
    }

    /**
     * Displays dice on the board
     * @param faceValue Takes int array an displays on GUI
     */
    public void displayDieOnBoard(int[] faceValue){
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
            _gui.getFields()[i%40].setCar(_players[playerID],false);
            _gui.getFields()[(i+1)%40].setCar(_players[playerID],true);
            try {
                sleep(65);
            } catch (InterruptedException e){
                _gui.showMessage("An error occurred");
            }
        }
    }

    /**
     * Place a player on start
     * @param playerID Which player to put on start
     */
    public void placePlayerOnStart(int playerID) {
        if (playerID > _players.length) {
            System.out.println("Error in ControllerGUI placePlayerOnStart playerID larger than amount of players");
            return;
        }
        _gui.getFields()[0].setCar(_players[playerID], true);
    }

    /**
     * Sets the amount of houses on a street on the GUI
     * @param fieldID Which field to place the house on
     * @param houseCount How many houses should be on the street
     */
    public void setHouseCount(int fieldID, int houseCount){
        try{
            GUI_Street street = (GUI_Street) _gui.getFields()[fieldID];
            street.setHouses(houseCount);
        } catch (RuntimeException e){
            System.out.println("WARNING: ControllerGUI placeHouse() casting not successful. Object that got casted to street: " + _gui.getFields()[fieldID].getClass().getName());
        }
    }

    /**
     * Place a hotel on a field. Removes all houses on the current field
     * @param fieldID Which field to place the hotel on
     */
    public void placeHotel(int fieldID){
        try{
            GUI_Street street = (GUI_Street) _gui.getFields()[fieldID];
            street.setHouses(0);
            street.setHotel(true);
        } catch (RuntimeException e){
            System.out.println("WARNING: ControllerGUI placehotel() casting not successful. Object that got casted to street: " + _gui.getFields()[fieldID].getClass().getName());
        }
    }

    /**
     * Remove a hotel on a field.
     * @param fieldID Which field to remove the hotel from
     */
    public void removeHotel(int fieldID){
        try{
            GUI_Street street = (GUI_Street) _gui.getFields()[fieldID];
            street.setHotel(false);
        } catch (RuntimeException e){
            System.out.println("WARNING: ControllerGUI removeHotel() casting not successful. Object that got casted to street: " + _gui.getFields()[fieldID].getClass().getName());
        }
    }
    /**
     * Sets the color and name of a field to indicate an owner of the field
     * @param fieldID The field ID used to set which field we are setting the owner of.
     * @param playerID The player ID used to set the owner name of the field.
     */
    public void setPropertyOwner(int fieldID, int playerID){
        try{
            GUI_Ownable ownable = (GUI_Ownable) _gui.getFields()[fieldID];
            ownable.setBorder(_ownedCarColors[playerID]);
            ownable.setOwnerName(_players[playerID].getName());
        } catch (RuntimeException e){
            System.out.println("WARNING: ControllerGUI setTileOwner() casting not successful. Object that got casted to street: " + _gui.getFields()[fieldID].getClass().getName());
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
