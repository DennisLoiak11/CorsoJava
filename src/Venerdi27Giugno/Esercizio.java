//Traccia: Controllo idoneità per un corso avanzato
//Scrivi un programma Java che chieda all’utente: 

//La sua età 
//Il numero di anni di esperienza in programmazione 
//Il numero di certificazioni ottenute 

//Il programma deve verificare se l’utente può accedere a un corso avanzato secondo questi criteri: 
//Deve avere più di 18 anni 
//E almeno 2 anni di esperienza 
//Oppure se ha almeno 1 certificazione e un’età compresa tra 16 e 18 anni (inclusi) 
//Inoltre, calcola e stampa la radice quadrata del numero totale di anni (età + esperienza), usando Math.sqrt. Stampa: 

//"Idoneo al corso" se soddisfa le condizioni 
//"Non idoneo al corso" altrimenti

import java.util.Scanner;

public class Esercizio {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] dati = new int[3];
        System.out.print("Quanti anni hai? ");
        dati[0]= scanner.nextInt(); //età
        System.out.print("Da quanti anni programmi? ");
        dati[1] = scanner.nextInt(); //anni esperiemza
        System.out.print("Quante certificazioni hai ottenuto fino ad ora? ");
        dati[2] = scanner.nextInt(); // numero certificazioni

        if (dati[0] > 18 && dati[1] >= 2) {
            System.out.println("Utente idoneo al corso");
        } else if (dati[0] >= 16 && dati[1] <= 18 && dati[2] >= 1) {
            System.out.println("Utente idoneo al corso");
        }else{
            System.out.println("Utente NON idoneo al corso");
        }

        int somma = dati[1] + dati[2];
        System.out.println("Radice quadrata" + Math.sqrt(somma)); //radice quadrata del numero totale di anni (età + esperienza)
        scanner.close();
    }
}
