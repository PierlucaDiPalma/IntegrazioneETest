package com.example.integrazioneetest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class AutomobileTest {
    static Automobile auto;

    @Test
    @BeforeAll
    static void setAuto(){
        auto = new Automobile("TT333RR", "Opel astra", "BERLINA", 5, 15, 5, 2022);
    }


    @Test
    void checkIfDateIsMajor() {
        assertFalse(auto.isDateMinor(3, 11, 2023));
    }

    @Test
    void checkIfDateIsMinor() {
        assertTrue(auto.isDateMinor(11, 5, 2023));
    }

    @ParameterizedTest
    @CsvSource({
            "32, 1, 2022",
            "31, 4, 2021",
            "30, 2, 2020",
            "29, 2, 2023",
            "0, 1, 2022"
    })
    void dayOutOfRange(int giorno, int mese, int anno){
        assertFalse(auto.isDateValid(giorno, mese, anno));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 13, 2022",
            "3, 0, 2023"
    })
    void monthOutOfRange(int giorno, int mese, int anno){
        assertFalse(auto.isDateValid(giorno, mese, anno));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 10, 2024",
            "3, 10, 1899"
    })
    void yearOutOFRange(int giorno, int mese, int anno){
        assertFalse(auto.isDateValid(giorno, mese, anno));
    }

    @ParameterizedTest
    @CsvSource({

            "31, 1, 1900",
            "29, 2, 2020",
            "28, 2, 2022",
            "1, 12, 2000",
            "30, 4, 2023"
    })
    void checkIfDateIsValid(int giorno, int mese, int anno) {
        assertTrue(auto.isDateValid(giorno, mese, anno));
    }
    /*
        @Test
        void check30IsValid(){
            assertTrue(auto.isDateValid(30, 4, 2023));
        }

        @Test
        void check29IsValid(){
            assertTrue(auto.isDateValid(29, 2 , 2020));
        }
    */
    @Test
    void checkIfModelloIsNullOrEmpty(){
        assertFalse(auto.isModelValid(2, null));
        assertFalse(auto.isModelValid(2, ""));
    }
    @Test
    void isModelValid() {
        assertTrue(auto.isModelValid(auto.getNumeroPorte(), auto.getModello()));
    }
    @ParameterizedTest
    @CsvSource({
            "3, Compact",
            "2, Compact",
            "5, Berlina",
            "3, Coupe",
            "5, SUV"
    })
    void checkIfModelIsRightByNDoors(int numPorte, String modello){

        assertTrue(auto.isModelValid(numPorte, modello));

    }

    @ParameterizedTest
    @CsvSource({
            "1, Compact",
            "5, Compact",
            "2, Berlina",
            "4, Coupe",
            "6, SUV"
    })
    void checkIfModelIsWrongByNDoors(int numPorte, String modello){

        assertFalse(auto.isModelValid(numPorte, modello));

    }


}