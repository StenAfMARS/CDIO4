package Game;
/**
 *
 */
public class DiceCarrier {
    private Die[] _diceArray;

    public DiceCarrier(int amountOfDices) {
        _diceArray = new Die[amountOfDices];
    }

    /**
     * Gives a random value between 1 and 6
     * @return The values of the dice rolls as an array.
     */
    public int[] rollDice() {
        int[] diceValues = new int[_diceArray.length];
        for (int i = 0; i < _diceArray.length; i++) {
            _diceArray[i].rollDice();
            diceValues[i] = _diceArray[i].get_value();
        }
        return diceValues;
    }
}
