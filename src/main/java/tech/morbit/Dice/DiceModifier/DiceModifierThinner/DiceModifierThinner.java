package tech.morbit.Dice.DiceModifier.DiceModifierThinner;

import java.util.ArrayList;
import java.util.List;

public abstract class DiceModifierThinner {

    protected int number;

    public DiceModifierThinner(int number) {
        this.number = number;
    }

    public void setNumber(int number) {this.number = number;}
    public int getNumber() {return number;}

    public abstract ArrayList<Integer> apply(ArrayList<Integer> rolls);
}
