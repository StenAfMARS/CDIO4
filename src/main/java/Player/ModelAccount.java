package Player;

public class ModelAccount {
    private int _money;

    /**
     * Account for keeping information about amounts of money
     * @param money Takes int as param for initial amount of money on the account
     * */
    public ModelAccount(int money){
        _money = money;
    }
    public int get_money(){
        return _money;
    }
    public void set_money(int money){
        _money = money;
    }
}
