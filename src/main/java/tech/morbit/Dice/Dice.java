package tech.morbit.Dice;

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
    private Random random = new Random();

    public Dice(int numDice, int sides) {
        this.numDice = numDice;
        this.sides = sides;

        /*
        // Handle modifiers (keep/drop, rerolls, etc.)
        if (modifier.contains("k")) {total = handleKeepModifier(diceResults, modifier, total);}
        else if (modifier.contains("d")) { total = handleDropModifier(diceResults, modifier, total);}
        else if (modifier.contains("r")) {total = handleRerollModifier(diceResults, modifier, total);}
        else if (modifier.contains("!")) {total = handleExplodingDice(diceResults, sides);}
        */

    }



    public int roll() {
        int total, current;
        total = 0;
        for (int i = 0; i < numDice; i++) {
            current = (random.nextInt(sides) + 1);



            total += current;
        }
        return total;
    }




    private static int rollDie(int sides) {
        return (int) (Math.random() * sides) + 1;
    }


}
