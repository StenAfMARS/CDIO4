package Player;

public class ModelPlayer {
    private String _name;
    private ModelAccount _account;
    private boolean _outOfJailFree;

    /**
     * Keeps information about a player
     * @param name takes String for name to player
     */
    public ModelPlayer(String name){
        _name = name;
        _account = new ModelAccount(30000);
        _outOfJailFree = false;
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
}
