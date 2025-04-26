package tech.morbit.Dice.DiceModifier.DiceModifierAfter;

import java.util.List;

public class DiceModifierAfterFilterDrop implements DiceModifierAfter {
    @Override
    public List<Integer> apply(List<Integer> rolls){
        return rolls;
    }
}
