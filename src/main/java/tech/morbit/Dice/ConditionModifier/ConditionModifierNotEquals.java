package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierNotEquals implements ConditionModifier {
    Comparable target = 0;

    public <T extends Comparable<T>>ConditionModifierNotEquals(T target) {
        this.target = target;
    };

    @Override
    public <T extends Comparable<T>> boolean check(T roll) {
        return roll.compareTo((T) this.target) != 0;
    }

}
