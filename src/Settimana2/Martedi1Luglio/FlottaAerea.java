package Settimana2.Martedi1Luglio;

import java.util.ArrayList;

class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;

    public Aereo(String modello, int numeroPosti, String codice) {
        this.modello = modello;
        this.numeroPosti = numeroPosti;
        this.codice = codice;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    // Impedisco l'inserimento di un numero di posti non valido
    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti > 0) {
            this.numeroPosti = numeroPosti;
        } else {
            System.out.println("Errore: il numero di posti deve essere positivo.");
        }
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    // Metodo per stampare tutte le informazioni dell'aereo
    public void stampaInfo() {
        System.out.println("Aereo - Modello: " + modello + ", Posti: " + numeroPosti + ", Codice: " + codice);
    }
}

class Pilota {
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        this.oreVolo = oreVolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }

    public void setNumeroBrevetto(String numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto;
    }

    public int getOreVolo() {
        return oreVolo;
    }

    // Impedisco l'inserimento di un valore non valido per le ore di volo
    public void setOreVolo(int oreVolo) {
        if (oreVolo > 0) {
            this.oreVolo = oreVolo;
        } else {
            System.out.println("Errore: le ore di volo devono essere maggiori di zero.");
        }
    }

    // Metodo per stampare tutte le informazioni del pilota
    public void stampaInfo() {
        System.out.println("Pilota - Nome: " + nome + ", Brevetto: " + numeroBrevetto + ", Ore di volo: " + oreVolo);
    }
}

class CompagniaAerea {
    private String nome;
    private ArrayList<Aereo> flotta;
    private ArrayList<Pilota> piloti;

    public CompagniaAerea(String nome) {
        this.nome = nome;
        this.flotta = new ArrayList<>();
        this.piloti = new ArrayList<>();
    }

    // Aggiungo un aereo all'elenco della flotta
    public void aggiungiAereo(Aereo aereo) {
        flotta.add(aereo);
    }

    // Aggiungo un pilota all'elenco dei piloti
    public void aggiungiPilota(Pilota pilota) {
        piloti.add(pilota);
    }

    // Stampo tutte le informazioni relative alla compagnia aerea
    public void stampaInformazioni() {
        System.out.println("Compagnia Aerea: " + nome);

        System.out.println("\n--- Flotta Aerei ---");
        for (Aereo a : flotta) {
            a.stampaInfo(); // Stampo info per ogni aereo
        }

        System.out.println("\n--- Piloti ---");
        for (Pilota p : piloti) {
            p.stampaInfo(); // Stampo info per ogni pilota
        }
    }
}

// Classe principale per eseguire il programma
public class FlottaAerea {

    public static void main(String[] args) {
        // Creo una nuova compagnia aerea
        CompagniaAerea compagnia = new CompagniaAerea("FidoFly Airlines");

        // Creo due aerei e li aggiungo alla compagnia
        Aereo a1 = new Aereo("Boeing 737", 180, "SF737-01");
        Aereo a2 = new Aereo("Airbus A320", 160, "SF320-02");

        // Creo due piloti e li aggiungo alla compagnia
        Pilota p1 = new Pilota("Marco Rossi", "BRV12345", 1200);
        Pilota p2 = new Pilota("Anna Bianchi", "BRV67890", 900);

        compagnia.aggiungiAereo(a1);
        compagnia.aggiungiAereo(a2);

        compagnia.aggiungiPilota(p1);
        compagnia.aggiungiPilota(p2);

        // Stampo le informazioni finali della compagnia
        compagnia.stampaInformazioni();
    }

}