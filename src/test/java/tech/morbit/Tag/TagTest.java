package tech.morbit.Tag;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TagTest {
    @Test
    @DisplayName("Constructor EmptyString")
    void constructorTestEmptyString() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Tag("");
        });

        assertEquals("Text is empty", e.getMessage());
    }
    @Test
    @DisplayName("Constructor Spaces")
    void constructorTestSpaces() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Tag("");
        });

        assertEquals("Text is empty", e.getMessage());
    }


}