package tech.morbit.Dice.DiceModifier.DiceModifierThinner;

import tech.morbit.Dice.DiceModifier.DiceModifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceModifierThinnerKeepLowest extends DiceModifierThinner {

    public DiceModifierThinnerKeepLowest(int number) {
        super(number);
    }

    @Override
    public ArrayList<Integer> apply(ArrayList<Integer> input) {
        List<Integer> inputCopy = List.copyOf(input);
        Collections.sort(inputCopy);

        List<Integer> filtered = new ArrayList<Integer>();
        for (int i = 0; i < number; i++) {
            filtered.add(input.get(i));
        }

        input.retainAll(filtered);
        return input;
    }
}
