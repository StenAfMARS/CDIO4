package Player;

public class ModelPlayer {
    private String _name;
    private ModelAccount _account;
    private boolean _outOfJail;

    /**
     * Keeps information about a player
     * @param name takes String for name to player
     */
    public ModelPlayer(String name){
        _name = name;
        _account = new ModelAccount(30000);
        _outOfJail = false;
    }

    public String get_name() {
        return _name;
    }
    public boolean is_outOfJail() {
        return _outOfJail;
    }

    public void set_outOfJail(boolean outOfJail) {
        _outOfJail = outOfJail;
    }

    public ModelAccount get_account() {
        return _account;
    }
}
