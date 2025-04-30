package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierEquals<T extends Comparable<T>> extends ConditionModifier{

    public ConditionModifierEquals(T target) {
        this.target = target;
    };

    @Override
    public boolean check(Comparable roll) {
        return roll.compareTo(this.target) == 0;
    }

    @Override
    public int compareTo(ConditionModifierRange o) {
        return 0;
    }

}
