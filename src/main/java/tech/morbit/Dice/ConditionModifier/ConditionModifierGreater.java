package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierGreater implements ConditionModifier {

    int target;

    public ConditionModifierGreater(int target) {
        this.target = target;
    }

    @Override
    public boolean check(int roll) {
        return roll > this.target;
    }
}
