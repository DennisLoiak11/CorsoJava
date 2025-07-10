package Settimana3.Lunedi7Luglio;

import java.util.Scanner;

class DatabaseManager {
    // Variabile per il ritorno dell'istanza Singleton della classe DatabaseManager
    private static DatabaseManager instance = null;

    // Contatore delle connessioni
    private int connectionCount = 0;

    // Costruttore privato per sovrascrivere il costruttore default di java e impedire la creazione di istanze della classe al di fuori di essa
    private DatabaseManager() {
    }

    // Metodo statico per ottenere l'istanza della classe DatabaseManager
    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
            System.out.println("Nuova istanza creata.");
        } else {
            System.out.println("Istanza già esistente.");
        }
        return instance;
    }

    // Metodo per simulare la cancellazione dell'istanza
    public static void deleteInstance() {
        if (instance != null) {
            instance = null;
            System.out.println("Istanza eliminata.");
        } else {
            System.out.println("Nessuna istanza da eliminare.");
        }
    }

    // Simula una connessione al database
    public void connect() {
        connectionCount++;
        System.out.println("Connessione stabilita. Connessioni attive: " + connectionCount);
    }

    // Ritorna il numero totale di connessioni
    public int getConnectionCount() {
        return connectionCount;
    }
}


public class EsercizioSingleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager manager = null;
        int scelta;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Crea un nuovo oggetto DatabaseManager");
            System.out.println("2. Usa l'oggetto per una connessione");
            System.out.println("3. Cancella l'oggetto");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    manager = DatabaseManager.getInstance();
                    break;
                case 2:
                    if (manager != null) {
                        manager.connect();
                    } else {
                        System.out.println("Errore: devi prima creare l'oggetto.");
                    }
                    break;
                case 3:
                    DatabaseManager.deleteInstance();
                    manager = null;
                    break;
                case 0:
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        scanner.close();
    }
}