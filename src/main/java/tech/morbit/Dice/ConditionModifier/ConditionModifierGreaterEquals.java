package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierGreaterEquals<T extends Comparable<T>>  extends ConditionModifier{

    public ConditionModifierGreaterEquals(T number) {
        this.target = number;
    }

    @Override
    public boolean check(Comparable roll) {
        return roll.compareTo(this.target) >= 0;
    }
}
