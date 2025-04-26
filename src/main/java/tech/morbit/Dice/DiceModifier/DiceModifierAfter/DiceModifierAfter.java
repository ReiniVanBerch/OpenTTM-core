package tech.morbit.Dice.DiceModifier.DiceModifierAfter;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;

import java.util.ArrayList;
import java.util.List;

public abstract class DiceModifierAfter {
    ConditionModifier conditionModifier = new ConditionModifierTrue();

    ArrayList<Integer> apply(ArrayList<Integer> rolls);

}
