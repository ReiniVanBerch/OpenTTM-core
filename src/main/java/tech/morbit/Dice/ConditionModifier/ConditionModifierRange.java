package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierRange implements ConditionModifier {

    ConditionModifier boundOne, boundTwo;

    //IF wrongly assigned, this will  always return false
    ConditionModifierRange(ConditionModifier boundOne, ConditionModifier boundTwo) {
        this.boundOne = boundOne;
        this.boundTwo = boundTwo;
    }

    @Override
    public boolean check(int roll) {
        return boundOne.check(roll) && boundTwo.check(roll);
    }
}
