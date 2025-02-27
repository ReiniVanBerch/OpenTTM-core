package tech.morbit.Quality;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tech.morbit.Quality.Tag;

import static org.junit.jupiter.api.Assertions.*;

class TagTest {
    @Test
    @DisplayName("Constructor EmptyString")
    void constructorTest() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Tag("");
        });

        assertEquals("Text is empty", e.getMessage());
    }



}