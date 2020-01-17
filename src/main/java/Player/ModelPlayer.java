package Player;

public class ModelPlayer {
    private String _name;
    private ModelAccount _account;
    private boolean _outOfJailFree;
    private boolean _inJail;
    private int _position;

    /**
     * Keeps information about a player
     * @param name takes String for name to player
     */
    ModelPlayer(String name,int money){
        _name = name;
        _account = new ModelAccount(money);
        _outOfJailFree = false;
        _position = 0;
    }

    String get_name() {
        return _name;
    }
    boolean is_outOfJailFree() {
        return _outOfJailFree;
    }

    void set_outOfJailFree(boolean outOfJailFree) {
        _outOfJailFree = outOfJailFree;
    }

    ModelAccount get_account() {
        return _account;
    }

    int get_position() {
        return _position;
    }

    void set_position(int _position) {
        this._position = _position;
    }

    boolean is_inJail() {
        return _inJail;
    }
    void set_inJail(boolean _inJail) {
        this._inJail = _inJail;
    }
}
