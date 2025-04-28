package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierSmallerEquals implements ConditionModifier {

    private Comparable target;

    public ConditionModifierSmallerEquals(int target) {
        this.target = target;
    }

    @Override
    public <T extends Comparable<T>> boolean check(T roll) {
        return roll.compareTo((T) this.target) <= 0;
    }
}
