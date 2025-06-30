package EsercizioFor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VotiUtente {
    public static void main(String[] args) {
        // Creo uno scanner per leggere l'input da tastiera
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indica quanti voti vuoi inserire: ");
        int numeroVoti = scanner.nextInt();
        int mediaVoti = 0;
        int sommaVoti = 0;
        // Creo una lista per memorizzare tutti i voti
        List<Integer> listaVoti = new ArrayList<>();

        // Controllo se l'utente inserisce un numero di voti negativo, e in caso si richiede di reinserirlo
        while(numeroVoti <= 0){
            System.out.print("Inserisci un numero positivo: ");
            numeroVoti = scanner.nextInt();
        }
        // Con il ciclo for chiedo di inserire i voti uno per uno
        for (int i = 0; i < numeroVoti; i++) {
            System.out.print("Inserisci un voto compreso tra 0 e 30: ");
            int voto = scanner.nextInt();
            // Se il voto inserito è negativo, si richiede di reinserirlo perchè non è valido
            while(voto < 0 || voto > 30) {
                System.out.print("Voto non valido, inserire un voto compreso tra 0 e 30: ");
                voto = scanner.nextInt();
            }
            // Con la condizione if verifico il voto per restituire un messaggio corrispondente
            if (voto >= 18 && voto < 24){
                System.out.println("Voto sufficente!");
            }else if(voto >= 24 && voto < 30){
                System.out.println("Voto buono!");
            }else if (voto == 30){
                System.out.println("Voto ottimo!");
            }else {
                System.out.println("Voto insufficente");
            }
            // Aggiungo ogni singolo voto alle lista dei voti
            listaVoti.add(voto);
        }
        // Utilizzo un ciclo forEach per sommare i voti
        for (int n : listaVoti){
            sommaVoti += n;
        }
        // Calcolo la media dei voti dividendo la somma per il numero di voti presenti nella lista
        mediaVoti = sommaVoti / listaVoti.size();
        System.out.println("La media dei voti è: " + mediaVoti);
    }
}
