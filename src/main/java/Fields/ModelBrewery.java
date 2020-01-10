package Fields;

public class ModelBrewery extends ModelProperty {
    private int _rent;

    /**Creates an instance of ModelBrewery
     * @param rent The "rent" of the brewery
     */
    public ModelBrewery(int rent) {
        // make sure rent is positive
        _rent = Math.max(rent, 0);
    }

    @Override
    public int get_rent() {
        return _rent;
    }
}
