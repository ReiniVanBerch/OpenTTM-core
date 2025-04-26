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

    private ArrayList<Integer> rolls;

    private List<DiceModifierDuring> modifiersDuring;
    private List<DiceModifierAfter> modifiersAfter;
    private DiceModifierCollector modifierCollector;
    private List<DiceModifierFinal> modifiersFinal;

    final private Random random = new Random();

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

    public List<DiceModifierFinal> getModifiersFinal() {
        return modifiersFinal;
    }

    public void setModifiersFinal(List<DiceModifierFinal> modifiersFinal) {
        this.modifiersFinal = modifiersFinal;
    }

    public DiceModifierCollector getModifierCollector() {
        return modifierCollector;
    }

    public void setModifierCollector(DiceModifierCollector modifierCollector) {
        this.modifierCollector = modifierCollector;
    }

    public List<DiceModifierAfter> getModifiersAfter() {
        return modifiersAfter;
    }

    public void setModifiersAfter(List<DiceModifierAfter> modifiersAfter) {
        this.modifiersAfter = modifiersAfter;
    }

    public List<DiceModifierDuring> getModifiersDuring() {
        return modifiersDuring;
    }

    public void setModifiersDuring(List<DiceModifierDuring> modifiersDuring) {
        this.modifiersDuring = modifiersDuring;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getNumDice() {
        return numDice;
    }

    public void setNumDice(int numDice) {
        this.numDice = numDice;
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
