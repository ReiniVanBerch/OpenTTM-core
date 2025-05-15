package tech.morbit.Dice.DiceModifier.DiceModifierThinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceModifierThinnerDropHighest {

    int number;

    public DiceModifierThinnerDropHighest(int number) {
        this.number = number;
    }

    public void setNumber(int number) {this.number = number;}
    public int getNumber() {return number;}

    public List<Integer> apply(List<Integer> input) {
        List<Integer> inputCopy = List.copyOf(input);
        Collections.sort(inputCopy, Collections.reverseOrder());

        List<Integer> filtered = new ArrayList<Integer>();
        for (int i = 0; i < number; i++) {
            filtered.add(input.get(i));
        }

        input.removeAll(filtered);
        return input;
    }
}
