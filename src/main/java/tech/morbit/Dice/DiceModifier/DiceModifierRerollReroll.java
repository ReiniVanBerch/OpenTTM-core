package tech.morbit.Dice.DiceModifier;

import tech.morbit.Dice.Dice;
import tech.morbit.Dice.DiceModifier.After.DiceModifierAfter;

import java.util.List;

public class DiceModifierRerollReroll implements DiceModifierAfter {
    public List<Integer> apply(List<Integer> roll){
        return roll;
    }
}
