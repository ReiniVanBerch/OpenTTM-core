package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierSmaller <T extends Comparable<T>> extends ConditionModifier {

    private Comparable target;

    public <T extends Comparable> ConditionModifierSmaller(T target) {
        this.target = target;
    }

    @Override
    public boolean check(Comparable roll) {
        return roll.compareTo(this.target) < 0;
    }
}
