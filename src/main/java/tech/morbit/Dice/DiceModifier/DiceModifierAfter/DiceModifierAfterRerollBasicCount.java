package tech.morbit.Dice.DiceModifier.DiceModifierAfter;

import java.util.List;

public class DiceModifierAfterRerollBasicCount implements DiceModifierAfter {    @Override
    public List<Integer> apply(List<Integer> roll){
        return roll;
    }
}
