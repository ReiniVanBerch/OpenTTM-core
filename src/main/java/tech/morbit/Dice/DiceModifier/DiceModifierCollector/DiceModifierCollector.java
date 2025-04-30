package tech.morbit.Dice.DiceModifier.DiceModifierCollector;

import tech.morbit.Dice.ConditionModifier.ConditionModifier;
import tech.morbit.Dice.ConditionModifier.ConditionModifierTrue;

import java.util.ArrayList;

public interface DiceModifierCollector {
    int apply(ArrayList<Integer> input);
}