package Lunedi30Giugno;

import java.util.Scanner;

public class Utente {
    String nome;
    String citta;
    int eta;

    public Utente(String nome, int eta) {
        this.nome = nome;
        this.citta = "Italia";
        this.eta = eta;
    }

    public String toString(){
        return nome + " - " + citta + " - " + eta;
    }

    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        System.out.print("Inserisci il nome dell'utente da creare: ");
        String nome = scannerString.nextLine();
        System.out.print("Inserisci l'età dell'utente da creare: ");
        int eta = scannerInt.nextInt();
        Utente u1 = new Utente(nome, eta);

        System.out.print("Inserisci il nome dell'utente da creare: ");
        String nome2 = scannerString.nextLine();
        System.out.print("Inserisci l'età dell'utente da creare: ");
        int eta2 = scannerInt.nextInt();
        Utente u2 = new Utente(nome2, eta2);

        System.out.println(u1);
        System.out.println(u2);
    }
}
