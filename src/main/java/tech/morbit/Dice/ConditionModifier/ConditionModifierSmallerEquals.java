package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierSmallerEquals implements ConditionModifier {
    int number;
    public ConditionModifierSmallerEquals(int number) {
        this.number = number;
    }

    @Override
    public boolean check(int roll) {
        return roll <= this.number;
    }
}
