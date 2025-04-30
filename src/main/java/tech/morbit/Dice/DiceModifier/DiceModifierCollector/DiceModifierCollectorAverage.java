package tech.morbit.Dice.DiceModifier.DiceModifierCollector;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;
import tech.morbit.Dice.DiceModifier.DiceModifier;

import java.util.ArrayList;

public class DiceModifierCollectorAverage extends DiceModifier implements DiceModifierCollector {


    public DiceModifierCollectorAverage() {}

    public DiceModifierCollectorAverage(ConditionModifier conditionModifier) {
        super(conditionModifier);
    }

    @Override
    public int apply(ArrayList<Integer> input) {
        int result = average(input);
        if (conditionModifier.check(result)) {
            return result;
        } else {
            return 0;
        }
    }

    public int average(ArrayList<Integer> input) {
        int sum = input.stream().mapToInt(i -> i).sum();
        return sum / input.size();
    }
}