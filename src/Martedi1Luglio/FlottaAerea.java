package Martedi1Luglio;

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

    public void setOreVolo(int oreVolo) {
        if (oreVolo > 0) {
            this.oreVolo = oreVolo;
        } else {
            System.out.println("Errore: le ore di volo devono essere maggiori di zero.");
        }
    }

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

    public void aggiungiAereo(Aereo aereo) {
        flotta.add(aereo);
    }

    public void aggiungiPilota(Pilota pilota) {
        piloti.add(pilota);
    }

    public void stampaInformazioni() {
        System.out.println("Compagnia Aerea: " + nome);
        System.out.println("\n--- Flotta Aerei ---");
        for (Aereo a : flotta) {
            a.stampaInfo();
        }

        System.out.println("\n--- Piloti ---");
        for (Pilota p : piloti) {
            p.stampaInfo();
        }
    }
}

public class FlottaAerea {

    public static void main(String[] args) {
        CompagniaAerea compagnia = new CompagniaAerea("SkyFly Airlines");

        Aereo a1 = new Aereo("Boeing 737", 180, "SF737-01");
        Aereo a2 = new Aereo("Airbus A320", 160, "SF320-02");

        Pilota p1 = new Pilota("Marco Rossi", "BRV12345", 1200);
        Pilota p2 = new Pilota("Anna Bianchi", "BRV67890", 900);

        compagnia.aggiungiAereo(a1);
        compagnia.aggiungiAereo(a2);

        compagnia.aggiungiPilota(p1);
        compagnia.aggiungiPilota(p2);

        compagnia.stampaInformazioni();
    }

}
