package tech.morbit.Dice;

import tech.morbit.Dice.DiceModifier.After.DiceModifierAfter;
import tech.morbit.Dice.DiceModifier.During.DiceModifierDuring;

import java.util.*;

public class Dice {

    /**
     *
     *
     * d is the Central element.
     * Before is the count
     * After is
     */

    private int numDice;
    private int sides;

    List<Integer> rolls;

    List<DiceModifierDuring> modifiersDuring;
    List<DiceModifierAfter> modifiersAfter;

    private Random random = new Random();

    public Dice(int numDice, int sides) {
        this.numDice = numDice;
        this.sides = sides;

        this.rolls = new ArrayList<>();

        /*
        // Handle modifiers (keep/drop, rerolls, etc.)
        if (modifier.contains("k")) {total = handleKeepModifier(diceResults, modifier, total);}
        else if (modifier.contains("d")) { total = handleDropModifier(diceResults, modifier, total);}
        else if (modifier.contains("r")) {total = handleRerollModifier(diceResults, modifier, total);}
        else if (modifier.contains("!")) {total = handleExplodingDice(diceResults, sides);}
        */

    }



    public int roll() {
        this.rolls.clear();

        int total, roll;
        total = 0;
        for (int i = 0; i < numDice; i++) {
            roll = (random.nextInt(sides) + 1);

            roll = applyModifiersDuring(roll);


            total += roll;
        }

        applyModifiersAfter(rolls);

        return total;
    }


    private int applyModifiersDuring(int roll){
        int sum = 0;
        for (int i = 0; i < modifiersDuring.size(); i++) {
            sum += modifiersDuring.get(i).apply(roll);
        }
        return sum;
    }

    private List<Integer> applyModifiersAfter(List<Integer> rolls) {
        for (int i = 0; i < modifiersAfter.size(); i++) {
            modifiersAfter.get(i).apply(rolls);
        }
        return rolls;
    }



}
