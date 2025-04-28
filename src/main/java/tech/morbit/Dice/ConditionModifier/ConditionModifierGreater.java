package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierGreater implements ConditionModifier {

    private Comparable target;

    public <T extends Comparable<T>> ConditionModifierGreater(T target) {
        this.target = target;
    }

    @Override
    public <T extends Comparable<T>> boolean check(T roll) {
        return roll.compareTo((T) this.target) > 0;
    }
}
