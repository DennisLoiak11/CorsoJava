package Venerdi4Luglio;

import java.util.ArrayList;

abstract class VeicoloConsegna{
    protected String targa;
    protected float caricoMassimo;

    public VeicoloConsegna(String targa, float caricoMassimo) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }

    //Metodo astratto della classe astratta che andrà implementato nella classe che estende VeicoloConsegna
    abstract void consegnaPacco(String destinazione);

    void stampaInfo(){
        System.out.println(" Targa veicolo: " + this.targa + "\n Carico massimo: " + this.caricoMassimo);
    }
}

interface Tracciabile{
    //Metodo astratto dell'interfaccia che andrà implementato nella classe che implementa Tracciabile
    void tracciaConsegna(String codiceTracking);
}

class Furgone extends VeicoloConsegna implements Tracciabile{
    public Furgone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    //Implementazione del metodo astratto della classe astratta
    public void consegnaPacco(String destinazione){
        System.out.println("Il furgone con targa " + targa + " è in consegna a " + destinazione);
    }

    //Implementazione del metodo astratto dell'interfaccia
    public void tracciaConsegna(String codiceTracking){
        System.out.println("Il codice tracking della consegna in furgone è: " + codiceTracking);
    }

}

class Drone extends VeicoloConsegna implements Tracciabile {
    public Drone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    //Implementazione del metodo astratto della classe astratta
    public void consegnaPacco(String destinazione) {
        System.out.println("Il drone con targa " + targa + " è in volo verso " + destinazione);
    }

    //Implementazione del metodo astratto dell'interfaccia
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Il codice tracking della consegna in drone è: " + codiceTracking);
    }
}

public class ConsegnaManager {
    public static void main(String[] args) {
        ArrayList<VeicoloConsegna> veicoli = new ArrayList<>();

        Furgone furgone = new Furgone("FR978", 52000);
        Drone drone = new Drone("DR523", 25000);

        veicoli.add(furgone);
        veicoli.add(drone);

        for(VeicoloConsegna veicolo : veicoli){
            veicolo.stampaInfo();
            veicolo.consegnaPacco("Via Verdi 58");
            //controlla se l’oggetto veicolo implementa l’interfaccia Tracciabile
            if(veicolo instanceof Tracciabile){
                //Se la condizione è vera si possono usare i metodi definiti dall’interfaccia effettuando
                // esplicitamente un cast a Tracciabile
                ((Tracciabile) veicolo).tracciaConsegna("LKU80Q23");
            }
        }
    }
}