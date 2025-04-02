package tech.morbit.Functional;

import java.util.*;
import java.util.regex.*;

import java.util.function.Function;

public class Die implements Functional {

    /**
     *
     *
     * d is the Central element.
     * Before is the count
     * After is
     */


    public Object apply(Object o) {
        return null;
    }

    @Override
    public void apply() {

    }

    public static void main(String[] args) {
        // Example inputs
        String input = "2d6+3";
        System.out.println("Roll Result: " + rollDice(input));

        input = "4d10k3";
        System.out.println("Roll Result: " + rollDice(input));

        input = "3d6r1";
        System.out.println("Roll Result: " + rollDice(input));

        input = "5d8!";
        //System.out.println("Roll Result: " + rollDice(input));
    }

    public static int rollDice(String input) {
        // Remove spaces and handle basic notation
        input = input.replaceAll("\\s", "");

        // Regular expression to parse the dice notation
        Pattern pattern = Pattern.compile("(\\d*)d(\\d+)([a-zA-Z\\d]*)");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid dice notation format.");
        }

        // Extract parts of the notation
        int numDice = matcher.group(1).isEmpty() ? 1 : Integer.parseInt(matcher.group(1)); // Default to 1 if not provided
        int sides = Integer.parseInt(matcher.group(2));
        String modifier = matcher.group(3);

        // Perform the dice roll
        List<Integer> diceResults = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < numDice; i++) {
            int roll = rollDie(sides);
            diceResults.add(roll);
            total += roll;
        }

        // Handle modifiers (keep/drop, rerolls, etc.)
        if (modifier.contains("k")) {
            total = handleKeepModifier(diceResults, modifier, total);
        } else if (modifier.contains("d")) {
            total = handleDropModifier(diceResults, modifier, total);
        } else if (modifier.contains("r")) {
            total = handleRerollModifier(diceResults, modifier, total);
        } else if (modifier.contains("!")) {
            total = handleExplodingDice(diceResults, total, sides);
        }

        return total;
    }

    private static int rollDie(int sides) {
        return (int) (Math.random() * sides) + 1;
    }

    private static int handleKeepModifier(List<Integer> diceResults, String modifier, int total) {
        if (modifier.startsWith("k")) {
            int keepCount = Integer.parseInt(modifier.substring(1));
            Collections.sort(diceResults, Collections.reverseOrder());
            diceResults = diceResults.subList(0, keepCount);
            total = diceResults.stream().mapToInt(Integer::intValue).sum();
        }
        return total;
    }

    private static int handleDropModifier(List<Integer> diceResults, String modifier, int total) {
        if (modifier.startsWith("d")) {
            int dropCount = Integer.parseInt(modifier.substring(1));

            Collections.sort(diceResults);

            for (int i = 0; i < dropCount; i++) {diceResults.remove(0);}

            total = diceResults.stream().mapToInt(Integer::intValue).sum();
        }
        return total;
    }

    private static int handleRerollModifier(List<Integer> diceResults, String modifier, int total) {
        if (modifier.startsWith("r")) {
            int rerollValue = Integer.parseInt(modifier.substring(1));

            for (int i = 0; i < diceResults.size(); i++) {
                // Reroll specific value
                if (diceResults.get(i) == rerollValue) {diceResults.set(i, rollDie(diceResults.get(i)));}
            }
            total = diceResults.stream().mapToInt(Integer::intValue).sum();
        }
        return total;
    }

    private static int handleExplodingDice(List<Integer> diceResults, int total, int sides) {
        List<Integer> explodedDice = new ArrayList<>();
        for (int roll : diceResults) {
            // Explode the die and reroll
            if (roll == sides) {explodedDice.add(rollDie(sides)); }
        }
        diceResults.addAll(explodedDice);
        total = diceResults.stream().mapToInt(Integer::intValue).sum();
        return total;
    }
}
