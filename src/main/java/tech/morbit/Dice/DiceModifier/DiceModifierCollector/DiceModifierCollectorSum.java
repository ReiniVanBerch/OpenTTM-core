package tech.morbit.Dice.DiceModifier.DiceModifierCollector;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;
import tech.morbit.Dice.DiceModifier.DiceModifier;
import tech.morbit.Dice.DiceModifier.DiceModifierDuring.DiceModifierDuringMath;

import java.util.ArrayList;

public class DiceModifierCollectorSum extends DiceModifier implements DiceModifierCollector {

    public DiceModifierCollectorSum() {}

    public DiceModifierCollectorSum(ConditionModifier conditionModifier) {
        super(conditionModifier);
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
