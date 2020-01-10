package Player;

public class ControllerPlayer {
    private ModelPlayer[] _playerArray;
    public void createPlayerArray(String[] names){
        for (int i = 0; i < names.length; i++) {
            _playerArray[i] = new ModelPlayer(names[i]);
        }
    }
    public ModelPlayer[] get_playerArray() {
        return _playerArray;
    }
}
