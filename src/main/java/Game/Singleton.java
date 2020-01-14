package Game;

public abstract class Singleton {

    private static Singleton _instance;

    public abstract static Singleton get()
    {
        if (_instance == null) {
            _instance = new Singleton();
        }
        return _instance;
    }

}
