package tech.morbit.Dice.DiceModifier.After;

import java.util.List;

public class DiceModifierAfterRerollAdvantage implements DiceModifierAfter {
    public List<Integer> apply(List<Integer> rolls){
        return rolls;
    }
}
