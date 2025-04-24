package tech.morbit.Dice.DiceModifier.DiceModifierFinal;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;
import tech.morbit.Dice.DiceModifier.DiceModifier;

public abstract class DiceModifierFinal extends DiceModifier {

    protected int number;
    protected ConditionModifier conditionModifier = new ConditionModifierTrue();


    public DiceModifierFinal(ConditionModifier conditionModifier) {
        super(conditionModifier);
    }

    public DiceModifierFinal(int number){

        this.number = number;
    }

    public DiceModifierFinal(int number, ConditionModifier conditionModifier) {
        this(number);
        this.conditionModifier = conditionModifier;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public abstract int apply(int collected);

    public boolean check(int collected){
        return this.conditionModifier.check(collected);
    }

}
