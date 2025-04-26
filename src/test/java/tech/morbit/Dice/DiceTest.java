package tech.morbit.Dice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {

    static Dice dice;

    @BeforeAll
    @DisplayName("Initializer")
    public static void init() {
        dice = new Dice(6,5);
    }

    @Test
    @DisplayName("Roll 1 Dice")
    public void Test_Roll1() {
        int roll = dice.getSingleRoll();
        System.out.println(roll);
        assertTrue(roll >=1 && roll <=6);
    }

    @Test
    @DisplayName("Roll 5 Dice")
    public void Test_Roll5() {
        ArrayList<Integer> rolls = dice.getRolls();
        for (int i = 0; i < rolls.size(); i++) {
            assertTrue(rolls.get(i) >=1 && rolls.get(i) <=6);
        }
    }

    @Test
    @DisplayName("Roll 5 Dice Sum")
    public void Test_Roll5Sum() {
        int sum = dice.roll();
        assertTrue(sum >=1*5 && sum <=6*5);
    }

}
