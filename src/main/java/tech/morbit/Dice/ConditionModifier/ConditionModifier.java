package tech.morbit.Dice.ConditionModifier;

public interface ConditionModifier {
    <T extends Comparable<T>> boolean check(T roll);
}
