package Player;

public class ModelPlayer {
    private String _name;
    private ModelAccount _account;
    private boolean _outOfJailFree;
    private int _position;
    private boolean _Lost;

    /**
     * Keeps information about a player
     * @param name takes String for name to player
     */
    ModelPlayer(String name,int money){
        _name = name;
        _account = new ModelAccount(money);
        _outOfJailFree = false;
        _position = 0;
        _Lost = false;
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

    public boolean get_Lost(){return _Lost;}

    public void set_Lost(Boolean Lost) {
        this._Lost = true;
    }
}
