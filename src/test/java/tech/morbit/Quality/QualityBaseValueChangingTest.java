package tech.morbit.Quality;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tech.morbit.Exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;

public class QualityBaseValueChangingTest {

    static private QualityBaseValueChanging cv;


    @Test
    @DisplayName("Constructor")
    public void testConstructor_Valid() {
        ArrayList al = new ArrayList(Arrays.asList(1));
        try {
            QualityBaseValueChanging cv = new QualityBaseValueChanging("Test", al);
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        }
    }

}
