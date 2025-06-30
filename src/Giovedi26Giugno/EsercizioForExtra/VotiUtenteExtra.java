package EsercizioForExtra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VotiUtenteExtra {
    public static void main(String[] args) {
        // Creo uno scanner per leggere l'input da tastiera
        Scanner scanner = new Scanner(System.in);
        int mediaVoti = 0;
        int sommaVoti = 0;
        // Creo una variabile per controllare il ciclo while e decidere se procedere con i voti di un altro studente o meno
        boolean continua = true;
        // Creo una lista per memorizzare tutti i voti
        List<Integer> listaVoti = new ArrayList<>();

        while(continua){
            System.out.print("Inserisci il nome dello studente a cui assegnare i voti: ");
            String nome = scanner.next();

            System.out.print("Indica quanti voti vuoi inserire: ");
            int numeroVoti = scanner.nextInt();

            while(numeroVoti <= 0){
                System.out.print("Inserisci un numero positivo: ");
                numeroVoti = scanner.nextInt();
            }

            for (int i = 0; i < numeroVoti; i++) {
                System.out.print("Inserisci un voto compreso tra 0 e 30: ");
                int voto = scanner.nextInt();

                while(voto < 0) {
                    System.out.print("Voto non valido, inserire un voto maggiore o uguale a zero: ");
                    voto = scanner.nextInt();
                }


                if (voto >= 18 && voto < 24){
                    System.out.println("Voto sufficente!");
                }else if(voto >= 24 && voto < 30){
                    System.out.println("Voto buono!");
                }else if (voto == 30){
                    System.out.println("Voto ottimo!");
                }else {
                    System.out.println("Voto insufficente");
                }
                listaVoti.add(voto);
            }
            for (int n : listaVoti){
                sommaVoti += n;
            }
            mediaVoti = sommaVoti / listaVoti.size();
            System.out.println("La media dei voti di " + nome +  " è: " + mediaVoti);
            System.out.print("Vuoi assegnare dei voti ad un altro studente? y/n: ");
            String conferma = scanner.next();
            if (conferma.equals("n")){
                continua = false;
            }
        }
        System.out.println("Programma terminato.");
        scanner.close();
    }
}
