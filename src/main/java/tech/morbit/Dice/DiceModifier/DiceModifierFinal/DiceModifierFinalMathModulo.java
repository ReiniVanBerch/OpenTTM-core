package tech.morbit.Dice.DiceModifier.DiceModifierFinal;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;

public class DiceModifierFinalMathModulo extends DiceModifierFinal {
    public DiceModifierFinalMathModulo(int number) {
        super(number);
    }

    public DiceModifierFinalMathModulo(int number, ConditionModifier conditionModifier) {
        super(number, conditionModifier);
    }

    @Override
    public int apply(int collected) {
        if(check(collected)) {
            return collected % number;
        }
        else{
            return collected;
        }
    }
}
