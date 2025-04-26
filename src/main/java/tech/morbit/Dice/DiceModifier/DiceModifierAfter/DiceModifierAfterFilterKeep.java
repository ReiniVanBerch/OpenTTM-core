package tech.morbit.Dice.DiceModifier.DiceModifierAfter;

import java.util.List;

public class DiceModifierAfterFilterKeep implements DiceModifierAfter {
    @Override
    public List<Integer> apply(List<Integer> rolls){
        return rolls;
    }
}
