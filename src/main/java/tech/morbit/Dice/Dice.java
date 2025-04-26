package tech.morbit.Dice;

import tech.morbit.Dice.DiceModifier.DiceModifierAfter.DiceModifierAfter;
import tech.morbit.Dice.DiceModifier.DiceModifierCollector.DiceModifierCollector;
import tech.morbit.Dice.DiceModifier.DiceModifierCollector.DiceModifierCollectorSum;
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

    private List<DiceModifierDuring> durings;
    private List<DiceModifierAfter> afters;
    private DiceModifierCollector collector;
    private List<DiceModifierFinal> finals;

    final private Random random = new Random();

    public Dice(int numDice, int sides) {
        durings = new ArrayList<>();
        afters = new ArrayList<>();
        finals = new ArrayList<>();

        collector = new DiceModifierCollectorSum();
        this.numDice = numDice;
        this.sides = sides;

        this.rolls = new ArrayList<>();
    }


    public int getSingleRoll(){
        return  (random.nextInt(sides) + 1);
    }

    //If you need to see teh rolls
    public ArrayList<Integer> getRolls() {
        this.rolls.clear();


        for (int i = 0; i < numDice; i++) {
            int roll = getSingleRoll();
            int rollAfter = applyModifiersDuring(roll);
            rolls.add(rollAfter);
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
        for (int i = 0; i < this.durings.size(); i++) {
            roll = this.durings.get(i).apply(roll);
        }
        return roll;
    }

    //What should be done with all the rolls after they have been rolled
    private ArrayList<Integer> applyModifiersAfter(ArrayList<Integer> rolls) {
        for (int i = 0; i < this.afters.size(); i++) {
            rolls = this.afters.get(i).apply(rolls);
        }
        return rolls;
    }

    //How should the dice be collected? Average? Difference? Etc.
    //Hence there can only be one collector
    private int applyModifierCollector(ArrayList<Integer> rolls) {
        int sum = this.collector.apply(rolls);
        return sum;
    }

    //What should be done with the result of the dice? Should be somet
    private int applyModifiersFinal(int collected) {
        for (int i = 0; i < this.finals.size(); i++) {
            collected = this.finals.get(i).apply(collected);
        }
        return collected;
    }



    public List<DiceModifierFinal> getModifiersFinal() {
        return finals;
    }

    public void addModifiersFinal(DiceModifierFinal modifierFinal) {
        this.finals.add(modifierFinal);
    }

    public void addModifiersFinal(List<DiceModifierFinal> finals){
        this.finals.addAll(finals);
    }

    public void setModifiersFinal(List<DiceModifierFinal> finals) {
        this.finals = finals;
    }

    public DiceModifierCollector getCollector() {
        return collector;
    }

    public void setCollector(DiceModifierCollector collector) {
        this.collector = collector;
    }

    public List<DiceModifierAfter> afters() {
        return afters;
    }

    public void addModifiersAfter(DiceModifierAfter modifierAfter) {
        this.afters.add(modifierAfter);
    }

    public void addModifiersAfter(List<DiceModifierAfter> modifierAfter){
        this.afters.addAll(modifierAfter);
    }

    public void setModifiersAfter(List<DiceModifierAfter> modifiersAfter) {
        this.afters = afters;
    }

    public List<DiceModifierDuring> getModifiersDuring() {
        return durings;
    }

    public void addModifiersDuring(DiceModifierDuring modifierDuring) {
        this.durings.add(modifierDuring);
    }

    public void addModifiersDuring(List<DiceModifierDuring> modifierDuring) {
        this.durings.addAll(modifierDuring);
    }

    public void setDiceModifiersDuring(List<DiceModifierDuring> durings) {
        this.durings = durings;
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
}
