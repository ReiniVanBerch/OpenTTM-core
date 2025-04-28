package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierRange implements ConditionModifier {

    ConditionModifier boundOne, boundTwo;

    //IF wrongly assigned, this will  always return false
    ConditionModifierRange(ConditionModifier boundOne, ConditionModifier boundTwo) {
        this.boundOne = boundOne;
        this.boundTwo = boundTwo;
    }

    @Override
    public  <T extends Comparable<T>> boolean check(T roll) {
        return boundOne.check(roll) && boundTwo.check(roll);
    }
}
