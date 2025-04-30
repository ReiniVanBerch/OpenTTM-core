package tech.morbit.Dice.DiceModifier.DiceModifierDuring;

public class DiceModifierDuringMathMultiply extends DiceModifierDuringMath implements DiceModifierDuring {
    @Override
    public int apply(int roll){
        if(check(roll)) {
            return roll * value;
        }
        else{
            return roll;
        }
    }
}
