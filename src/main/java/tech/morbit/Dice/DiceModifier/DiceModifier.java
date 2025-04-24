package tech.morbit.Dice.DiceModifier;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;

public abstract class DiceModifier {

    protected ConditionModifier conditionModifier = new ConditionModifierTrue();

    public DiceModifier() {}

    public DiceModifier(ConditionModifier conditionModifier) {
        this.conditionModifier = conditionModifier;
    }

    public ConditionModifier getConditionModifier() {
        return conditionModifier;
    }


    public void setConditionModifier(ConditionModifier conditionModifier) {
        this.conditionModifier = conditionModifier;
    }

    public boolean check(int collected){
        return this.conditionModifier.check(collected);
    }
}
