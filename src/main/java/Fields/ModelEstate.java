package Fields;

public class ModelEstate extends ModelProperty {
    private int[] _rent;
    private int _amountOfHouses;
    private int _housePrice;

    /**Creates an instance of ModelEstate
     * @param rent an array of how much rent is with x amount of houses. MUST be 6 long
     * @param housePrice The price of a house on the Estate.
     */
    public ModelEstate(int[] rent, int housePrice) {
        _rent = rent.clone();

        // make sure rent is positive
        for (int i = 0; i < _rent.length; i++) {
            _rent[i] = Math.max(_rent[i], 0);
        }

        _amountOfHouses = 0;

        // make sure house price is positive
        _housePrice = Math.max(housePrice, 0);
    }

    public int get_amountOfHouses() {
        return _amountOfHouses;
    }
    public void set_amountOfHouses(int _amountOfHouses) {
        this._amountOfHouses = _amountOfHouses;
    }

    public int get_housePrice() {
        return _housePrice;
    }
    public void set_housePrice(int _housePrice) {
        this._housePrice = _housePrice;
    }

    @Override
    public int get_rent() {
        return _rent[_amountOfHouses];
    }
}
