package Player;

public class ModelPlayer {
    private String name;
    private ModelAccount account;
    private boolean outOfJail = false;
    public ModelPlayer(String name){
        this.name = name;
        account = new ModelAccount(30000);
    }

    public String getName() {
        return name;
    }
    public boolean isOutOfJail() {
        return outOfJail;
    }

    public void setOutOfJail(boolean outOfJail) {
        this.outOfJail = outOfJail;
    }

    public ModelAccount getAccount() {
        return account;
    }
}
