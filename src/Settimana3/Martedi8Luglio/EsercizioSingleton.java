package Settimana3.Martedi8Luglio;

import java.util.ArrayList;
import java.util.List;

interface Investitore {
    void notifica(String azione, double valore);
}

class InvestitorePrivato implements Investitore {
    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Investitore Privato: Nuovo valore di " + azione + " è " + valore + "€");
    }
}

class InvestitoreBancario implements Investitore {
    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Investitore Bancario: Attenzione! L'azione " + azione + " vale ora " + valore + "€");
    }
}

class AgenziaBorsa {
    private static AgenziaBorsa istanza;
    private List<Investitore> investitori;

    // Costruttore privato
    private AgenziaBorsa() {
        investitori = new ArrayList<>();
    }

    // Metodo statico per ottenere l'unica istanza (Lazy Initialization)
    public static synchronized AgenziaBorsa getInstance() {
        if (istanza == null) {
            istanza = new AgenziaBorsa();
        }
        return istanza;
    }

    public void aggiungiInvestitore(Investitore i) {
        investitori.add(i);
    }

    public void rimuoviInvestitore(Investitore i) {
        investitori.remove(i);
    }

    public void notificaInvestitori(String azione, double valore) {
        for (Investitore i : investitori) {
            i.notifica(azione, valore);
        }
    }

    public void aggiornaValoreAzione(String azione, double valore) {
        System.out.println("Aggiornamento azione: " + azione + " a " + valore + "€");
        notificaInvestitori(azione, valore);
    }
}

public class EsercizioSingleton {
    public static void main(String[] args) {
        AgenziaBorsa borsa = AgenziaBorsa.getInstance();

        Investitore i1 = new InvestitorePrivato();
        Investitore i2 = new InvestitoreBancario();

        borsa.aggiungiInvestitore(i1);
        borsa.aggiungiInvestitore(i2);

        borsa.aggiornaValoreAzione("Quota Tesla", 120.75);
        borsa.aggiornaValoreAzione("Quota Netflix", 98.40);
    }
}
