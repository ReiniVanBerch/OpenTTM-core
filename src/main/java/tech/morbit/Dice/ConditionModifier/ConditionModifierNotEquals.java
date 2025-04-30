package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierNotEquals<T extends Comparable<T>> extends ConditionModifier {

    public ConditionModifierNotEquals(T target) {
        this.target = target;
    };

    @Override
    public  boolean check(Comparable roll) {
        return roll.compareTo((T) this.target) != 0;
    }

}
