package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierNotEquals implements ConditionModifier {
    int target = 0;

    public ConditionModifierNotEquals(int target) {
        this.target = target;
    };

    @Override
    public boolean check(int roll) {
        return roll != target;
    }

}
