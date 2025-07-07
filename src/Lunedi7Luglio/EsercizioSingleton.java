package Lunedi7Luglio;

class DatabaseManager {
    // variabile per l'istanza Singleton
    private static DatabaseManager instance;

    // contatore delle connessioni
    private int connectionCount = 0;

    // costruttore privato per sovrascrivere il costruttore di default di java e impedire la creazione di istanze al di fuori della classe
    private DatabaseManager() {
        // Costruttore privato per impedire l'istanziazione diretta
    }

    // metodo statico per ottenere l'istanza
    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    // metodo per simulare la connessione al database
    public void connect() {
        connectionCount++;
        System.out.println("Connessione stabilita. Connessioni attive: " + connectionCount);
    }

    // metodo per restituisce il numero totale di connessioni
    public int getConnectionCount() {
        return connectionCount;
    }
}

public class EsercizioSingleton {
    public static void main(String[] args) {
        // due oggetti ma stessa istanza della classe
        DatabaseManager db1 = DatabaseManager.getInstance();
        DatabaseManager db2 = DatabaseManager.getInstance();

        // verifica che l'istanza degli oggetti sia la stessa
        System.out.println("db1 == db2? " + (db1 == db2));  // deve stampare true

        // richiamo i metodi per la simulazione delle connessioni
        db1.connect();
        db2.connect();
        db1.connect();

        // stampa totale connessioni
        System.out.println("Numero totale di connessioni: " + db1.getConnectionCount());
    }
}