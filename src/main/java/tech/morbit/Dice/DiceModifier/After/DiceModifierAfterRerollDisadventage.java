package tech.morbit.Dice.DiceModifier.After;

import java.util.List;

public class DiceModifierAfterRerollDisadventage implements DiceModifierAfter {
    public List<Integer> apply(List<Integer> rolls){
        return rolls;
    }
}
