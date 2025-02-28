package tech.morbit.Character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    Character character;
    @BeforeEach
    void init() {
        character = new Character("Frank");
    }

    @Test
    @DisplayName("getName")
    void getName() {
        String expected = "Frank";
        String actual = character.getName();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("setName correct")
    void setNameCorrect() {
        String expected = "Peter";
        character.setName(expected);

    }

    @Test
    @DisplayName("setName empty")
    void setNameEmpty() {
    }

    @Test
    @DisplayName("setName whitespaces")
    void setNameWhiteSpaces() {
    }

    @Test
    void setQualities() {
    }

    @Test
    void setQuality() {
    }

    @Test
    void getQualities() {
    }

    @Test
    void getQualitiesAsString() {
    }

    @Test
    void addQuality() {
    }

    @Test
    void testToString() {
    }
}