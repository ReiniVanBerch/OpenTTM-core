package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierGreaterEquals implements ConditionModifier{
    int number;
    public ConditionModifierGreaterEquals(int number) {
        this.number = number;
    }

    @Override
    public boolean check(int roll) {
        return roll >= this.number;
    }
}
