package tech.morbit.Dice.DiceModifier.DiceModifierCollector;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;

import java.util.ArrayList;

public class DiceModifierCollectorAverage implements DiceModifierCollector {

    ConditionModifier conditionModifier = new ConditionModifierTrue();

    public DiceModifierCollectorAverage() {}

    public DiceModifierCollectorAverage(ConditionModifier conditionModifier) {
        this.conditionModifier = conditionModifier;
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