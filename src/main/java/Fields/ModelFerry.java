package Fields;

 class ModelFerry extends ModelProperty {
    private int _rent;

    /**Creates an instance of ModelFerry
     * @param rent The "rent" of the ferry
     */
     ModelFerry(int rent) {
        // make sure rent is positive
        _rent = Math.max(rent, 0);
    }

    @Override
     int get_rent() {
        return _rent;
    }
}
