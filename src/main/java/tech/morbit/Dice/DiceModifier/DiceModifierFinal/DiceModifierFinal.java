package tech.morbit.Dice.DiceModifier.DiceModifierFinal;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;

public abstract class DiceModifierFinal {

    protected int number;
    protected ConditionModifier conditionModifier = new ConditionModifierTrue();


    DiceModifierFinal(int number){
        this.number = number;
    }

    DiceModifierFinal(int number, ConditionModifier conditionModifier) {
        this(number);
        this.conditionModifier = conditionModifier;
    }

    public ConditionModifier getConditionModifier() {
        return conditionModifier;
    }

    public int getNumber() {
        return number;
    }

    public void setConditionModifier(ConditionModifier conditionModifier) {
        this.conditionModifier = conditionModifier;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public abstract int apply(int collected);

    boolean check(int collected){
        return this.conditionModifier.check(collected);
    }

}
