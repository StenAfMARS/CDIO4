package Player;

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
    public void changeAmountOfMoney(int moneyChange, int playerID){
        _playerArray[playerID].get_account().set_money(_playerArray[playerID].get_account().get_money() - moneyChange);
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
    public void setPlayerPosition(int playerID , int playerPosition){
        _playerArray[playerID].set_position(playerPosition);
    }
    public void updatePlayerPosition(int playerID, int playerPosition){
        setPlayerPosition(playerID,getPlayerPosition(playerID) +  playerPosition);
    }
}
