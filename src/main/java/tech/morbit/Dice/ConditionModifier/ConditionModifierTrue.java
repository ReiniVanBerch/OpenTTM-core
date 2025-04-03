package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierTrue implements ConditionModifier {

    /**
     * @param roll
     * @return
     */
    @Override
    public boolean check(int roll) {
        return true;
    }
}
