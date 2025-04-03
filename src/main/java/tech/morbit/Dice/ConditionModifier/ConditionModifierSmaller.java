package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierSmaller implements ConditionModifier {
    int number;

    public ConditionModifierSmaller(int number) {
        this.number = number;
    }

    /**
     * @param roll
     * @return
     */
    @Override
    public boolean check(int roll) {
        return roll < this.number;
    }
}
