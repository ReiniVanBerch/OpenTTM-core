package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierSmallerEquals extends ConditionModifier {

    private Comparable target;

    public ConditionModifierSmallerEquals(int target) {
        this.target = target;
    }

    @Override
    public boolean check(Comparable roll) {
        return roll.compareTo( this.target) <= 0;
    }
}
