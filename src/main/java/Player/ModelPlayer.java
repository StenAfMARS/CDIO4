package Player;

public class ModelPlayer {
    private String _name;
    private ModelAccount _account;
    private boolean _outOfJailFree;
    private int _position;

    /**
     * Keeps information about a player
     * @param name takes String for name to player
     */
    public ModelPlayer(String name,int money){
        _name = name;
        _account = new ModelAccount(money);
        _outOfJailFree = false;
        _position = 0;
    }

    public String get_name() {
        return _name;
    }
    public boolean is_outOfJailFree() {
        return _outOfJailFree;
    }

    public void set_outOfJailFree(boolean outOfJailFree) {
        _outOfJailFree = outOfJailFree;
    }

    public ModelAccount get_account() {
        return _account;
    }

    public int get_position() {
        return _position;
    }

    public void set_position(int _position) {
        this._position = _position;
    }
}
