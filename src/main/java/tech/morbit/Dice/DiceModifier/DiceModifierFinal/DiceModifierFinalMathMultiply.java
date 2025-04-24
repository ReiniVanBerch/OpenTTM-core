package tech.morbit.Dice.DiceModifier.DiceModifierFinal;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;

public class DiceModifierFinalMathMultiply extends DiceModifierFinal {

    public DiceModifierFinalMathMultiply(int number) {
        super(number);
    }

    public DiceModifierFinalMathMultiply(int number, ConditionModifier conditionModifier) {
        super(number, conditionModifier);
    }

    @Override
    public int apply(int collected) {
        if(check(collected)) {
            return collected + number;
        }
        else{
            return collected;
        }
    }
}
