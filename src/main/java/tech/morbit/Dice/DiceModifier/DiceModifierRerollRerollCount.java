package tech.morbit.Dice.DiceModifier;

import tech.morbit.Dice.DiceModifier.After.DiceModifierAfter;
import tech.morbit.Dice.DiceModifier.During.DiceModifierDuring;

import java.util.List;

public class DiceModifierRerollRerollCount implements DiceModifierAfter {    @Override
    public List<Integer> apply(List<Integer> roll){
        return roll;
    }
}
