package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierTrue<T extends Comparable<T>> extends ConditionModifier {

    @Override
    public boolean check(Comparable roll) {
        return true;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
