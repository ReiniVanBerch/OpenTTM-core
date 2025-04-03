package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierSmaller implements ConditionModifier {
    int number;

    public ConditionModifierSmaller(int number) {
        this.number = number;
    }

    @Override
    public boolean check(int roll) {
        return roll < this.number;
    }
}
