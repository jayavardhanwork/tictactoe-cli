package org.example.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    void canCreateNewGame(){
        Game g = new Game("❌","⭕");

        assertEquals("❌",g.getP1().getCharacter());
        assertEquals("⭕",g.getP2().getCharacter());

        assertNull(g.getCharInTheBox(1));
        assertNull(g.getCharInTheBox(2));
        assertNull(g.getCharInTheBox(3));
        assertNull(g.getCharInTheBox(4));
        assertNull(g.getCharInTheBox(5));
        assertNull(g.getCharInTheBox(6));
        assertNull(g.getCharInTheBox(7));
        assertNull(g.getCharInTheBox(8));
        assertNull(g.getCharInTheBox(9));

        assertEquals(g.getP1(),g.getNextTurn());

    }

    @Test
    void canMarkBoxesViaAttempt(){
        Game g = new Game("❌","⭕");
        g.nextAttempt(1);
        assertEquals("❌",g.getCharInTheBox(1));
        assertEquals(g.getP2(),g.getNextTurn());

        //check if already marked boxes are not allowed to mark
        assertThrowsExactly(IllegalStateException.class, () -> {g.nextAttempt(1);});


    }

    @Test
    void throwsExceptionForInvalidBoxAttempt(){
        Game g = new Game("❌","⭕");
        assertThrowsExactly(IllegalArgumentException.class, () -> {g.nextAttempt(10);});
    }

    @Test
    void checksIfProperVictory(){
        Game g = new Game("❌","⭕");
        assertNull(g.checkVictory());
    }
}
