
package Game;

public class Die {
    private int _value;
    private int _faces;

    /**
     * Die class constructor
     * @param _faces
     */
    public Die(int _faces) {
        this._faces = _faces;
    }

    /**
     *
     * @return It returns the value of the last dice roll
     */
    public int get_value() {
        return this._value;
    }

    /**
     * Rolls the dice
     * @return The value of the roll
     */
    public int rollDice() {
        return this._value = (int)(Math.random() * this._faces) + 1;
    }

}
