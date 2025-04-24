package tech.morbit.Dice.DiceModifier.DiceModifierFinal;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;

public class DiceModifierFinalMathAdd extends DiceModifierFinal {

    public DiceModifierFinalMathAdd(int number) {
        super(number);
    }

    public DiceModifierFinalMathAdd(int number, ConditionModifier conditionModifier) {
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
