package com.example.integrazioneetest;

import java.util.Calendar;
import java.time.LocalDate;

public class Automobile {
    private static String extarga = "^[A-z]{2}[0-9]{3}[A-z]{2}$";
    private String targa;
    private String nome;
    private String modello;
    private int numeroPorte;
    private int giornoImmatricolazione;
    private int meseImmatricolazione;
    private int annoImmatricolazione;
    private String[] modelli = {"Compact", "Coupe", "Berlina", "Suv"};
    public Automobile(String targa, String nome, String modello, int numeroPorte, int giornoImmatricolazione, int meseImmatricolazione,
                      int annoImmatricolazione) {
        if((((targa.matches(extarga)) && (isDateValid(giornoImmatricolazione, meseImmatricolazione, annoImmatricolazione)))
                &&(isModelValid(numeroPorte, modello)))&&(isDateMinor(giornoImmatricolazione, meseImmatricolazione, annoImmatricolazione)))
        {
            this.targa = targa;
            this.nome = nome;
            this.modello = modello;
            this.numeroPorte = numeroPorte;
            this.giornoImmatricolazione = giornoImmatricolazione;
            this.meseImmatricolazione = meseImmatricolazione;
            this.annoImmatricolazione = annoImmatricolazione;
            System.out.println("Auto creata correttamente");
        }
    }

    public String getModello() {
        return modello;
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }

    public boolean isDateValid(int giorno, int mese, int anno) {

        if ((anno >= 1900) && (anno <= Calendar.getInstance().get(Calendar.YEAR))) {
            if ((mese >= 1 )&& (mese<= 12)) {
                //controllo giorni
                if ((giorno >= 1 && giorno <= 31) && (mese == 1 || mese == 3 || mese == 5 || mese == 7 ||
                        mese == 8 || mese == 10 || mese == 12)) {

                    return true;
                }
                else if ((giorno >= 1 && giorno <= 30) && (mese == 4 || mese == 6 || mese == 9 || mese == 11)){

                    return true;
                }
                else if ((giorno >= 1 && giorno <= 28) && (mese == 2)){

                    return true;
                }
                else if (giorno == 29 && mese == 2 && (anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0))){

                    return true;
                }
                else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isModelValid(int numeroPorte, String modello) {

        boolean contains = false;
        if (modello != null) {
            for (int i = 0; i < modelli.length; i++) {
                if (modelli[i].toUpperCase().equals(modello.toUpperCase())) {
                    contains = true;
                    break;
                }
            }
            if (contains) {
                if (numeroPorte == 2 && modello.toUpperCase().equals("COMPACT")) {
                    return true;
                } else if (numeroPorte == 3 && (modello.toUpperCase().equals("COMPACT") || modello.toUpperCase().equals("COUPE"))) {
                    return true;
                } else if (numeroPorte == 5 && (modello.toUpperCase().equals("BERLINA") || modello.toUpperCase().equals("SUV"))) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } else {
            return false;
        }
    }
    public boolean isDateMinor(int giornoImm, int meseImm, int annoImm){

        LocalDate dataInserita = LocalDate.of(annoImm, meseImm, giornoImm);
        LocalDate dataAttuale = LocalDate.now();

        return dataInserita.isBefore(dataAttuale);

    }

}

