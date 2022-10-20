package org.example.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    void constructPlayerWithCharacter () {
        Player p1 = new Player("❌");
        assertEquals("❌", p1.getCharacter());
    }
}
