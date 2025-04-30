package tech.morbit.Dice.DiceModifier.DiceModifierDuring;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.DiceModifier.DiceModifier;

public abstract class DiceModifierDuringMath extends DiceModifier {
    protected int value = 0;
    protected DiceModifierDuringMath() {
        super();
    }

    protected DiceModifierDuringMath(ConditionModifier conditionModifier) {
        super(conditionModifier);
    }


    protected DiceModifierDuringMath(ConditionModifier conditionModifier, int value) {
        super(conditionModifier);
        this.value = value;
    }

    protected DiceModifierDuringMath(int value) {
        this.value = value;
    }

    public int getValue(){return value;};
    public void setValue(int value){this.value = value;};
}
