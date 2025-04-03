package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierTrue implements ConditionModifier {

    @Override
    public boolean check(int roll) {
        return true;
    }
}
