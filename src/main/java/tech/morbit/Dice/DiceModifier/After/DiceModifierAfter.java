package tech.morbit.Dice.DiceModifier.After;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;

import java.util.List;

public interface DiceModifierAfter {
    ConditionModifier conditionModifier = new ConditionModifierTrue();

    List<Integer> apply(List<Integer> rolls);

}
