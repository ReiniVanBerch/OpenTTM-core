package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierGreaterEquals implements ConditionModifier{

    private Comparable target;

    public <T extends Comparable> ConditionModifierGreaterEquals(T number) {
        this.target = number;
    }

    @Override
    public <T extends Comparable<T>> boolean check(T roll) {
        return roll.compareTo((T) this.target) >= 0;
    }
}
