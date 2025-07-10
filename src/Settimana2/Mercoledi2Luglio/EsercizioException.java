package Settimana2.Mercoledi2Luglio;

import java.util.Scanner;

class Controller {
    //Creazione del metodo che lancia l'eccezione personalizzata NumeroNegativoException
    public static void checkPositive(int n) throws NumeroNegativoException {
        if(n < 0){
            throw new NumeroNegativoException("Il numero inserito deve essere positivo", null);
        }else{
            System.out.println("Il numero inserito è: " + n);
        }
    }
    //Creazione del metodo che lancia l'eccezione personalizzata NumeroZeroException
    public static void checkNotZero(int n){
        if(n == 0){
            throw new NumeroZeroException("Il numero inserito deve essere diverso da 0", null);
        }else{
            System.out.println("Il numero inserito è: " + n);
        }
    }
}

public class EsercizioException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Procedere con la divisione? 1=Si, 2=No: ");
            int scelta = leggiIntero(scanner);

            if (scelta == 2) {
                System.out.println("Arrivederci e grazie.");
                break;
            } else if (scelta == 1) {
                //Apertura del blocco try per inserire il codice che potrebbe generare un eccezione
                try {
                    System.out.print("Inserisci il primo numero (deve essere positivo): ");
                    int primo = leggiIntero(scanner);
                    //Con il metodo static della classe Controller verifico che il numero inserito sia maggiore di zero altrimenti scatta l'eccezione
                    Controller.checkPositive(primo);

                    System.out.print("Inserisci il secondo numero (divisore, diverso da 0): ");
                    int secondo = leggiIntero(scanner);
                    //Con il metodo static della classe Controller verifico che il numero inserito sia diverso da zero altrimenti scatta l'eccezione
                    Controller.checkNotZero(secondo);

                    // Se non ci sono eccezioni esegue la divisione
                    double risultato = (double) primo / secondo;
                    System.out.println(primo + " / " + secondo + " = " + risultato);
                }
                //Tramite il catch, se scatta un eccezione nel blocco try riusciamo a "catturarla" per gestirla
                catch (NumeroNegativoException e) {
                    e.printStackTrace();
                    System.out.println("Errore: " + e.getMessage());
                }
                catch (NumeroZeroException e) {
                    e.printStackTrace();
                    System.out.println("Errore: " + e.getMessage());
                }
            } else {
                System.out.println("Scelta non valida. Inserire 1 o 2.");
            }
        }
        scanner.close();
    }

    // Metodo bloccante per leggere solo interi
    public static int leggiIntero(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Input non valido. Inserisci un numero intero: ");
            }
        }
    }
}