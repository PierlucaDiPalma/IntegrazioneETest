package com.example.integrazioneetest;
public class Swaps {

    /**
     * metodo per lo scambio di due lettere in una stringa. Date due interi, corrispondenti alle posioni nella stringa,
     * il metodo scambia le due lettere nelle posioni corrispondenti.
     * Se i due interi sono maggiori della lunghezza della stringa vengono aggiunti dei caratteri per estenderla
     * e rendere possibile lo scambio
     * */
    public static String swapLetters(int pos1, int pos2, String inputString, int numMax) {

        if (pos1 <= 0 || pos2 <= 0 || pos1 >= pos2) {
            return null;
        }

        int stringLength = inputString.length();

        if ((pos1 > stringLength || pos2 > stringLength) && (pos2<=numMax)) {
            int leftPadding = pos1 - stringLength; // leftPadding = 2
            int rightPadding = pos2 - stringLength; // rightPadding = 3

            StringBuilder stringBuilder = new StringBuilder();

            //aggiunge x a sinistra
            for (int i = 0; i < leftPadding; i++) {
                stringBuilder.append("x");
            }

            //aggiugne x a destra
            stringBuilder.append(inputString);

            for (int i = 0; i < rightPadding; i++) {
                stringBuilder.append("x");
            }
            //inputString = xxabcdxxx
            inputString = stringBuilder.toString();

        }

        char[] charArray = inputString.toCharArray();

        char temp = charArray[pos1-1]; //posizioni decrementate per la gestione dell'array
        charArray[pos1-1] = charArray[pos2-1];
        charArray[pos2-1] = temp;

        // Stringa restituita: xxabcxdxx
        return new String(charArray);
    }

}
