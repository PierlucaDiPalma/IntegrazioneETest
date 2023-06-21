package com.example.integrazioneetest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapsTest {

    @Test
    void PosMinorThanZero(){
        assertNull(Swaps.swapLetters(-1, 2, "Ciao", 5));
    }

    @Test
    void PosOverTheLimit(){
        assertEquals("xxcanxexx", Swaps.swapLetters(6, 7, "cane", 10));
    }

}