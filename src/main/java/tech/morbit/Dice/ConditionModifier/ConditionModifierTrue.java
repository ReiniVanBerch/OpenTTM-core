package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierTrue implements ConditionModifier {

    @Override
    public <T extends Comparable<T>> boolean check(T roll) {
        return true;
    }

}
