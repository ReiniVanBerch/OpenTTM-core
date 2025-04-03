package tech.morbit.Dice.DiceModifier.After;

import java.util.List;

public class DiceModifierAfterMathDivide implements DiceModifierAfter {
    @Override
    public List<Integer> apply(List<Integer> rolls){
        return rolls;
    }
}
