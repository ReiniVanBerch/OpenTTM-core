package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierEquals implements ConditionModifier {

    int target = 0;

    public ConditionModifierEquals(int target) {
        this.target = target;
    };

    @Override
    public boolean check(int roll) {
        return roll == target;
    }
}
