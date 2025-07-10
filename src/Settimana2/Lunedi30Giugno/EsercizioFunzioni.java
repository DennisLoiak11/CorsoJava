package Settimana2.Lunedi30Giugno;

import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioFunzioni {

    //Esercizio 1
    public int somma(int a, int b){
        return a + b;
    }

    //Esercizio 2
    public int multiply(int a, int b){
        return a * b;
    }

    public double multiply(double a, double b){
        return a * b;
    }

    //Esercizio 3
    public int sommaRicorsiva(int n){
        if (n == 1) {
            return 1;
        }
        return n + sommaRicorsiva(n - 1);
    }

    //Esercizio 4
    public static void modificaPrimitiva(int numero) {
        numero = 100;
        System.out.println("Dentro modificaPrimitiva: numero = " + numero);
    }

    public static void modificaArray(int[] numeri) {
        numeri[0] = 100;
        System.out.println("Dentro modificaArray: numeri[0] = " + numeri[0]);
    }

    //Esercizio 5
    public void stampaElementi(){
        ArrayList<String> parole = new ArrayList<>();
        parole.add("Aldo Baglio");
        parole.add("Giacomo Poretti");
        parole.add("Giovanni Storti");
        for(String p : parole){
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        EsercizioFunzioni e = new EsercizioFunzioni();

        while(continua == true){
            System.out.print("\nQuale funzione vuoi chiamare? (0 per uscire) 1, 2, 3, 4, 5 -> ");
            int scelta = scanner.nextInt();
            switch (scelta){

                case 1:
                    System.out.println("Hai scelto la somma di due numeri!");
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Inserisci il primo numero della somma: ");
                    int x = scanner1.nextInt();
                    System.out.print("Inserisci il secondo numero: ");
                    int z = scanner1.nextInt();
                    System.out.println("Somma di due numeri: " + e.somma(x, z));
                    break;

                case 2:
                    System.out.println("Hai scelto di moltiplicare due numeri!");
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.print("Vuoi moltiplicare due numeri interi o due numeri con la virgola? interi/virgola -> ");
                    String scelta2 = scanner2.nextLine();
                    if (scelta2.toLowerCase().equals("interi")){
                        System.out.print("Inserisci il primo numero -> ");
                        int p = scanner2.nextInt();
                        System.out.print("Inserisci il secondo numero -> ");
                        int u = scanner2.nextInt();
                        System.out.println("Il risultato della moltiplicazione è: " + e.multiply(p, u));
                    }else if(scelta2.toLowerCase().equals("virgola")){
                        System.out.print("Inserisci il primo numero con la virgola -> ");
                        double pp = scanner2.nextDouble();
                        System.out.print("Inserisci il secondo numero con la virgola -> ");
                        double uu = scanner2.nextDouble();
                        System.out.println("Moltiplica due numeri con la virgola: " + e.multiply(pp, uu));
                    }else{
                        System.out.println("Errore: prossima volta scrivi meglio");
                    }
                    break;

                case 3:
                    System.out.println("Hai scelto la somma ricorsiva!");
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.print("Inserisci un numero positivo da cui partire con la somma: ");
                    int numeroPartenza = scanner3.nextInt();
                    System.out.println("La somma ricorsiva del numero " + numeroPartenza + " è: " + e.sommaRicorsiva(numeroPartenza));
                    break;

                case 4:
                    System.out.println("Hai scelto di modificare un valore!");
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.print("Vuoi modificare una variabile primitiva o un array? primitiva/array ");
                    String scelta3 = scanner4.nextLine();
                    if(scelta3.toLowerCase().equals("primitiva")){
                        int l = 10;
                        System.out.println("Prima di modificaPrimitiva = " + l);
                        modificaPrimitiva(l);
                        System.out.println("Dopo modificaPrimitiva = " + l);
                    } else if (scelta3.toLowerCase().equals("array")) {
                        int[] numeri = {10, 20, 30};
                        System.out.println("Prima di modificaArray: numeri[0] = " + numeri[0]);
                        modificaArray(numeri);
                        System.out.println("Dopo modificaArray: numeri[0] = " + numeri[0]);
                    }else{
                        System.out.println("Errore: prossima volta scrivi meglio");
                    }
                    break;

                case 5:
                    System.out.println("Hai scelto di visualizzare gli elementi presenti nell'ArrayList!");
                    e.stampaElementi();
                    break;

                case 0:
                    System.out.println("Arrivederci e grazie!");
                    continua = false;
            }
        }
    }

}