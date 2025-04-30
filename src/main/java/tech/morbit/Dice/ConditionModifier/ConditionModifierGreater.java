package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierGreater<T extends Comparable<T>>  extends ConditionModifier {


    public ConditionModifierGreater(T target) {
        this.target = target;
    }

    @Override
    public boolean check(Comparable roll) {
        return roll.compareTo(this.target) > 0;
    }

}
