package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierGreater implements ConditionModifier {
    int number;
    public ConditionModifierGreater(int number) {
        this.number = number;
    }

    /**
     * @param roll
     * @return
     */
    @Override
    public boolean check(int roll) {
        return roll > this.number;
    }
}
