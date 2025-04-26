package tech.morbit.Dice.DiceModifier.DiceModifierAfter;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;

import java.util.ArrayList;
import java.util.List;

public interface DiceModifierAfter {
    ConditionModifier conditionModifier = new ConditionModifierTrue();

    public abstract ArrayList<Integer> apply(ArrayList<Integer> rolls);

}
