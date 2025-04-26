package tech.morbit.Features;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnTrackerTest {

    TurnTracker turnTracker;

    @BeforeAll
    @DisplayName("Initializer")
    public static void init() {

    }

    @Test
    @DisplayName("Empty Constructor")
    public void test_TurnTracker_Constructor() {
        TurnTracker turnTracker = new TurnTracker();
        ArrayList<Object> actual = turnTracker.getEntities();

        ArrayList<Object> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Empty Constructor")
    public void test_TurnTracker_ConstructorFilled() {
        ArrayList<Object> expected = new ArrayList<>(Arrays.asList("Fire", "Water"));

        TurnTracker turnTracker = new TurnTracker(expected);
        ArrayList<Object> actual = turnTracker.getEntities();

        assertEquals(actual, expected);
    }

}
