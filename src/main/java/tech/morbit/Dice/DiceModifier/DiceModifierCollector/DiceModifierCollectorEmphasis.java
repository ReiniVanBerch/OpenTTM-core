package tech.morbit.Dice.DiceModifier.DiceModifierCollector;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;
import tech.morbit.Dice.DiceModifier.DiceModifier;

import java.util.ArrayList;

public class DiceModifierCollectorEmphasis extends DiceModifier implements DiceModifierCollector {

    ConditionModifier conditionModifier = new ConditionModifierTrue();
    private int numEmphasised = 0;

    public DiceModifierCollectorEmphasis(){}
    public DiceModifierCollectorEmphasis(ConditionModifier conditionModifier){
        super(conditionModifier);
    }

    public DiceModifierCollectorEmphasis(int numEmphasised){
        this.numEmphasised = numEmphasised;
    }
    public DiceModifierCollectorEmphasis(int numEmphasised, ConditionModifier conditionModifier){
        super(conditionModifier);
        this.numEmphasised = numEmphasised;
    }

    @Override
    public int apply(ArrayList<Integer> input) {
        return 0;
    }

    public ConditionModifier getConditionModifier() {
        return conditionModifier;
    }

    public void setConditionModifier(ConditionModifier conditionModifier) {
        this.conditionModifier = conditionModifier;
    }
}
