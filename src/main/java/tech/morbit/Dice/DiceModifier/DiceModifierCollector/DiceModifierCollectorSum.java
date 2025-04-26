package tech.morbit.Dice.DiceModifier.DiceModifierCollector;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;

import java.util.ArrayList;

public class DiceModifierCollectorSum implements DiceModifierCollector {

    ConditionModifier conditionModifier = new ConditionModifierTrue();

    public DiceModifierCollectorSum(){}
    public DiceModifierCollectorSum(ConditionModifier conditionModifier){
        this.conditionModifier = conditionModifier;
    }

    @Override
    public int apply(ArrayList<Integer> input) {
        int result = sum(input);
        if(conditionModifier.check(result)){
            return result;
        } else{
            return 0;
        }
    }

    public int sum(ArrayList<Integer> input) {
        return input.stream().mapToInt(i -> i).sum();
    }
}
