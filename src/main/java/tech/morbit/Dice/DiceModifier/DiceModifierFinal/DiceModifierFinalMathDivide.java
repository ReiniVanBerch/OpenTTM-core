package tech.morbit.Dice.DiceModifier.DiceModifierFinal;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;

public class DiceModifierFinalMathDivide extends DiceModifierFinal {

    public DiceModifierFinalMathDivide(int number){
        super(number);
    }

    public DiceModifierFinalMathDivide(int number, ConditionModifier conditionModifier) {
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
