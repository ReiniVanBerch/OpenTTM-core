package tech.morbit.Dice.DiceModifier.DiceModifierThinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceModifierThinnerDropLowest extends DiceModifierThinner {

    public DiceModifierThinnerDropLowest(int number) {
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

        input.removeAll(filtered);
        return input;
    }



}
