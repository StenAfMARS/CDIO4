package Player;

import Fields.ControllerField;
import Game.ControllerGUI;

public class ControllerPlayer {
    private ModelPlayer[] _playerArray;

    private static ControllerPlayer _instance;

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
        for (int i = 0; i < names.length; i++) {
            _playerArray[i] = new ModelPlayer(names[i],30000);
        }
    }

    /**
     * Method for charging players a fee or adding money to their account
     * @param moneyChange Amount of money to change from the players account
     * @param playerID Which player to change
     */
    public void setPlayerMoney(int moneyChange, int playerID){
        ModelPlayer player = _playerArray[playerID];
        ModelAccount account = player.get_account();

        int newBalance = account.get_money() + moneyChange;

        ControllerGUI.get().updatePlayer(playerID, newBalance);
        account.set_money(newBalance);
    }
    public int getPlayerMoney(int playerID){
        return _playerArray[playerID].get_account().get_money();
    }

    public String getPlayerName(int playerID){
        return _playerArray[playerID].get_name();
    }

    public boolean hasPlayerLost(int playerID){
        if (playerID < 0 || playerID >= _playerArray.length)
            return true;

        return _playerArray[playerID].get_account().get_money() < 0;
    }

    public int playerCount(){
        return _playerArray.length;
    }

    public int getPlayerPosition(int playerID){
        return _playerArray[playerID].get_position();
    }

    public void setPlayerPosition(int playerID , int newPosition){
        if (newPosition < getPlayerPosition(playerID))
            newPosition += ControllerField.get().getFieldLength();

        ModelPlayer player = _playerArray[playerID];
        ControllerGUI.get().movePlayer(playerID, player.get_position(), newPosition);
        player.set_position(newPosition % ControllerField.get().getFieldLength());
        if (!player.is_outOfJailFree() && player.get_position() % 30 == 0){
            ControllerGUI.get().movePlayer(playerID,player.get_position(),player.get_position() + 20);
            player.set_position((player.get_position() + 20) % ControllerField.get().getFieldLength());
        }
        else if (newPosition > ControllerField.get().getFieldLength())
            player.get_account().set_money(player.get_account().get_money() + 4000);
    }
    public void changePlayerPosition(int playerID, int deltaPosition){
        setPlayerPosition(playerID, _playerArray[playerID].get_position() + deltaPosition);
    }
}
