package tech.morbit.Quality;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tech.morbit.Exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangingValueTest {

    static private ChangingValue cv;


    @Test
    @DisplayName("Constructor")
    public void testConstructor_Valid() {
        ArrayList al = new ArrayList(Arrays.asList(1));
        try {
            ChangingValue cv = new ChangingValue("Test", al);
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }
    }

}
