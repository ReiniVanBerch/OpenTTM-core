package tech.morbit.Dice.DiceModifier;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;
import tech.morbit.Dice.Dice;

import java.util.List;

public interface DiceModifier {

    ConditionModifier conditionModifier = new ConditionModifierTrue();

    void beforeRoll(Dice dice);
    void afterRoll(Dice dice, List<Integer> rolls);
}
