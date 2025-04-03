package tech.morbit.Dice.DiceModifier.During;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;

import java.util.List;

public interface DiceModifierDuring {

    ConditionModifier conditionModifier = new ConditionModifierTrue();
    int apply(int roll);
}
