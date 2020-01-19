package Player;

import Fields.ControllerField;
import Game.ControllerGUI;

public class ControllerPlayer {
    private ModelPlayer[] _playerArray;

    private static ControllerPlayer _instance;

    //Singleton so there is only one instance of ControllerPlayer
    private ControllerPlayer(){}
    public static ControllerPlayer get()
    {
        if (_instance == null) {
            _instance = new ControllerPlayer();
        }
        return _instance;
    }
    /**
     * Creates a list of players with given names
     * @param names Takes a String array to create a list of players
     */
    public void createPlayerArray(String[] names){
        _playerArray = new ModelPlayer[names.length];
        //Create players with all names given
        for (int i = 0; i < names.length; i++) {
            _playerArray[i] = new ModelPlayer(names[i],30000);
        }
    }

    /**
     * Method for charging players a fee or adding money to their account
     * @param moneyChange Amount of money to change from the players account
     * @param playerID Which player to change
     */
    public void changePlayerMoney(int moneyChange, int playerID){
        //If player is in jail and moneyChange is large than 0 return.
        // Prevents player from getting rent in jail. If player is dead skip as well
        if ((_playerArray[playerID].is_inJail() && moneyChange > 0) || _playerArray[playerID].is_dead())
            return;
        //Current Player
        ModelPlayer player = _playerArray[playerID];
        //Current Players Account
        ModelAccount account = player.get_account();

        int newBalance = account.get_money() + moneyChange;
        //Update the players money in Model and on GUI
        ControllerGUI.get().updatePlayer(playerID, newBalance);
        account.set_money(newBalance);
        //Check if player lost after loosing money
        hasPlayerLost(playerID);
    }

    public String getPlayerName(int playerID){
        return _playerArray[playerID].get_name();
    }

    /**
     * A method to check if a player has lost. If the player has lost remove from GUI
     * @param playerID Which player to check
     * @return Returns a boolean if the player is dead return true
     */
    public boolean hasPlayerLost(int playerID){
        //If playerID is larger or less than the amount return false,
        if (playerID < 0 || playerID >= _playerArray.length)
            return false;
        //Tell ModelPlayer to be dead and remove from GUI if the player has no money
        if (_playerArray[playerID].get_account().get_money() < 0) {
            _playerArray[playerID].set_dead(true);
            ControllerGUI.get().killPlayer(playerID);
        }

        return _playerArray[playerID].is_dead();
    }

    public int playerCount(){
        return _playerArray.length;
    }

    public int getPlayerPosition(int playerID){
        return _playerArray[playerID].get_position();
    }

    public void setPlayerPosition(int playerID , int newPosition){
        if ((_playerArray[playerID].is_inJail() && newPosition != 10) || _playerArray[playerID].is_dead())
            return;

        //If the new position is less that player pos then add field length
        if (newPosition < getPlayerPosition(playerID))
            newPosition += ControllerField.get().getFieldLength();
        //Current player
        ModelPlayer player = _playerArray[playerID];
        //Move player to new position on GUI
        ControllerGUI.get().movePlayer(playerID,getPlayerPosition(playerID),newPosition);
        //Remember move in Model
        player.set_position(newPosition % ControllerField.get().getFieldLength());
        //If the player has passed start give money
        if (newPosition >= ControllerField.get().getFieldLength())
            changePlayerMoney(4000, playerID);
    }
    public void changePlayerPosition(int playerID, int deltaPosition){
        setPlayerPosition(playerID, _playerArray[playerID].get_position() + deltaPosition);
    }

    /**
     * Place/remove a player from Jail
     * @param playerID Which player
     * @param isInJail
     */
    public void setPlayerJailed(int playerID, boolean isInJail){
        if (isInJail && _playerArray[playerID].is_outOfJailFree()) {
            _playerArray[playerID].set_outOfJailFree(false);
            return;
        }

        _playerArray[playerID].set_inJail(isInJail);
        setPlayerPosition(playerID, 10);
    }
    public boolean isPlayerJailed(int playerID){
        return _playerArray[playerID].is_inJail();
    }
    public void setOutOfJailFree(int playerID){
        _playerArray[playerID].set_outOfJailFree(true);
    }
}
