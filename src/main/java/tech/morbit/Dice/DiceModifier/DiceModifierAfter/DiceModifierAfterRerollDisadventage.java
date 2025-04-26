package tech.morbit.Dice.DiceModifier.DiceModifierAfter;

import java.util.ArrayList;
import java.util.List;

public class DiceModifierAfterRerollDisadventage implements DiceModifierAfter {

    @Override
    public ArrayList<Integer> apply(ArrayList<Integer> rolls) {
        return rolls;
    }
}
