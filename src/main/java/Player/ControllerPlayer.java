package Player;

public class ControllerPlayer {
    private ModelPlayer[] _playerArray;
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
    public ModelPlayer[] get_playerArray(){
        return _playerArray;
    }
}
