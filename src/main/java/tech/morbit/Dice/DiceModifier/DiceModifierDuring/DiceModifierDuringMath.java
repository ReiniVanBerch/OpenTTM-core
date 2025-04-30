package tech.morbit.Dice.DiceModifier.DiceModifierDuring;

import tech.morbit.Dice.DiceModifier.DiceModifier;

public abstract class DiceModifierDuringMath extends DiceModifier {
    protected int value = 0;

    public int getValue(){return value;};
    public void setValue(int value){this.value = value;};
}
