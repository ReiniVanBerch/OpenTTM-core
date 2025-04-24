package tech.morbit.Dice.DiceModifier.DiceModifierAfter;

import java.util.List;

public class DiceModifierAfterRerollBasic implements DiceModifierAfter {
    public List<Integer> apply(List<Integer> roll){
        return roll;
    }
}
