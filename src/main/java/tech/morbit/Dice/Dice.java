package tech.morbit.Dice;

import tech.morbit.Dice.DiceModifier.DiceModifierAfter.DiceModifierAfter;
import tech.morbit.Dice.DiceModifier.DiceModifierCollector.DiceModifierCollector;
import tech.morbit.Dice.DiceModifier.DiceModifierDuring.DiceModifierDuring;
import tech.morbit.Dice.DiceModifier.DiceModifierFinal.DiceModifierFinal;

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

    ArrayList<Integer> rolls;

    List<DiceModifierDuring> modifiersDuring;
    List<DiceModifierAfter> modifiersAfter;
    DiceModifierCollector modifierCollector;
    List<DiceModifierFinal> modifiersFinal;

    private Random random = new Random();

    public Dice(int numDice, int sides) {
        this.numDice = numDice;
        this.sides = sides;

        this.rolls = new ArrayList<>();
    }


    public int singleRoll(){
        return  (random.nextInt(sides) + 1);
    }

    //If you need to see teh rolls
    public ArrayList<Integer> getRolls() {
        this.rolls.clear();


        for (int i = 0; i < numDice; i++) {
            int roll = singleRoll();
            rolls.add(applyModifiersDuring(roll));
        }

        rolls = applyModifiersAfter(rolls);
        return rolls;
    }

    //If you just need a numeric result of the given rolls
    public int roll() {
        ArrayList<Integer> rolls = getRolls();
        int value = applyModifierCollector(rolls);
        return applyModifiersFinal(value);
    }


    //Applies the different modifiers, which will be triggered for each roll
    private int applyModifiersDuring(int roll){
        int sum = 0;
        for (int i = 0; i < this.modifiersDuring.size(); i++) {
            sum += this.modifiersDuring.get(i).apply(roll);
        }
        return sum;
    }

    //What should be done with all the rolls after they have been rolled
    private ArrayList<Integer> applyModifiersAfter(ArrayList<Integer> rolls) {
        for (int i = 0; i < this.modifiersAfter.size(); i++) {
            this.modifiersAfter.get(i).apply(rolls);
        }
        return rolls;
    }

    //How should the dice be collected? Average? Difference? Etc.
    //Hence there can only be one collector
    private int applyModifierCollector(ArrayList<Integer> rolls) {
        int sum = this.modifierCollector.apply(rolls);
        return sum;
    }

    //What should be done with the result of the dice? Should be somet
    private int applyModifiersFinal(int collected) {
        for (int i = 0; i < this.modifiersAfter.size(); i++) {
            collected = this.modifiersFinal.get(i).apply(collected);
        }
        return collected;
    }



}
