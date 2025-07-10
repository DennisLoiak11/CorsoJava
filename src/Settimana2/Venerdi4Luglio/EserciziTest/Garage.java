package Settimana2.Venerdi4Luglio.EserciziTest;

class Veicolo {
    protected String marca;
    protected String modello;
    protected int anno;

    public Veicolo(String marca, String modello, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }

    public String toString() {
        return "Veicolo: " + marca + " " + modello + ", Anno: " + anno;
    }
}

class Auto extends Veicolo {
    private int numeroPorte;

    public Auto(String marca, String modello, int anno, int numeroPorte) {
        super(marca, modello, anno);
        this.numeroPorte = numeroPorte;
    }

    @Override
    public String toString() {
        return super.toString() + ", Porte: " + numeroPorte;
    }
}

class Moto extends Veicolo {
    private String tipoManubrio;

    public Moto(String marca, String modello, int anno, String tipoManubrio) {
        super(marca, modello, anno);
        this.tipoManubrio = tipoManubrio;
    }
    @Override
    public String toString() {
        return super.toString() + ", Tipo Manubrio: " + tipoManubrio;
    }
}

public class Garage {
    public static void main(String[] args) {
        Auto miaAuto = new Auto("Fiat", "Panda", 2015, 5);
        Moto miaMoto = new Moto("Ducati", "Monster", 2022, "Sportivo");

        System.out.println(miaAuto);
        System.out.println(miaMoto);
    }
}
