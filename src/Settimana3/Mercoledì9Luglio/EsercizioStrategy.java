package Settimana3.Mercoledì9Luglio;

//interfaccia con il metodo astratto che sarà implementato da Adizione e Moltiplicazione
interface Operazione {
    int esegui(int a, int b);
}

//classe concreta Addizione che implementa l'interfaccia Operazione e il suo metodo astratto
class Addizione implements Operazione {
    @Override
    public int esegui(int a, int b) {
        return a + b;
    }
}

//classe concreta Moltiplicazione che implementa l'interfaccia Operazione e il suo metodo astratto
class Moltiplicazione implements Operazione {
    @Override
    public int esegui(int a, int b) {
        return a * b;
    }
}

class Calcolatore {
    private Operazione strategia;

    public void setStrategia(Operazione strategia) {
        this.strategia = strategia;
    }

    public int eseguiOperazione(int a, int b) {
        return strategia.esegui(a, b);
    }
}

public class EsercizioStrategy {
    public static void main(String[] args) {
        Calcolatore calcolatore = new Calcolatore();

        //utilizzo della strategia Addizione
        calcolatore.setStrategia(new Addizione());
        System.out.println("Addizione: 5 + 3 = " + calcolatore.eseguiOperazione(5, 3));

        //utilizzo della strategia Moltiplicazione
        calcolatore.setStrategia(new Moltiplicazione());
        System.out.println("Moltiplicazione: 5 * 3 = " + calcolatore.eseguiOperazione(5, 3));
    }
}
