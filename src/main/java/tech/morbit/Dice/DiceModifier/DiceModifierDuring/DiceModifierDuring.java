package tech.morbit.Dice.DiceModifier.DiceModifierDuring;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;

public interface DiceModifierDuring {

    ConditionModifier conditionModifier = new ConditionModifierTrue();
    int apply(int roll);
}
