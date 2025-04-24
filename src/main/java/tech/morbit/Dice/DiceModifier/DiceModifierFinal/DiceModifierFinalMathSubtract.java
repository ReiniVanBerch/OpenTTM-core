package tech.morbit.Dice.DiceModifier.DiceModifierFinal;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;

public class DiceModifierFinalMathSubtract extends DiceModifierFinal {

    public DiceModifierFinalMathSubtract(int number) {
        super(number);
    }

    public DiceModifierFinalMathSubtract(int number, ConditionModifier conditionModifier) {
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
