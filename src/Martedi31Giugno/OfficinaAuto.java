package Martedi31Giugno;

import java.util.ArrayList;
import java.util.Scanner;

class Officina {
    ArrayList<Auto> automobili;

    public Officina() {
        this.automobili = new ArrayList<>();
    }

    void aggiungiAuto(Auto auto){
        automobili.add(auto);
    }

    void displayAllAuto(){
        if (automobili.isEmpty()) {
            System.out.println("Nessuna auto presente in officina.");
        } else {
            System.out.println("======================================");
            System.out.println("         Lista delle Auto             ");
            System.out.println("======================================");
            for (Auto auto : automobili) {
                System.out.println("Targa   : " + auto.getTarga());
                System.out.println("Modello : " + auto.getModello());
                System.out.println("--------------------------------------");
            }
        }
    }
}

class Auto {
    private String targa;
    private String modello;

    public Auto(String targa, String modello) {
        this.targa = targa;
        this.modello = modello;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }
}

public class OfficinaAuto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Officina officina = new Officina();
        int scelta = 0;
        //Finchè la scelta è diversa da 3 continua a proporre il menù di azioni da poter svolgere
        while (scelta != 3) {
            System.out.println("\n===== MENU OFFICINA =====");
            System.out.println("1. Aggiungi una nuova auto");
            System.out.println("2. Visualizza tutte le auto");
            System.out.println("3. Esci");
            System.out.print("Scegli un'opzione: ");
            if (scanner.hasNextInt()) {
                scelta = scanner.nextInt();
                scanner.nextLine(); // Pulisce il buffer
            } else {
                System.out.println("Input non valido. Inserisci un numero.");
                scanner.nextLine(); // Pulisce l'input per prepararsi all'input successivo
                continue; // Torna all'inizio del ciclo
            }

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci la targa dell'auto: ");
                    String targa = scanner.nextLine();
                    System.out.print("Inserisci il modello dell'auto: ");
                    String modello = scanner.nextLine();
                    //Anche se si creano più oggetti con lo stesso nome, noi possiamo salvare nell'ArrayList salviamo il valore di ogni oggetto creato
                    Auto nuovaAuto = new Auto(targa, modello);
                    //Salvo l'oggetto Auto nell'ArrayList per memorizzare il valore
                    officina.aggiungiAuto(nuovaAuto);
                    System.out.println("Auto aggiunta con successo!");
                    break;
                case 2:
                    officina.displayAllAuto();
                    break;
                case 3:
                    System.out.println("Arrivederci e grazie...");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        scanner.close();
    }
}