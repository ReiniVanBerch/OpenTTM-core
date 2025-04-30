package tech.morbit.Dice.ConditionModifier;

public class ConditionModifierRange<T extends Comparable<T>> extends ConditionModifier {

    ConditionModifier target1, target2;

    //IF wrongly assigned, this will  always return false
    ConditionModifierRange(ConditionModifier boundOne, ConditionModifier boundTwo) {
        this.target1 = boundOne;
        this.target2 = boundTwo;
    }

    @Override
    public boolean check(Comparable roll) {
        return target1.check(roll) && target1.check(roll);
    }
}
