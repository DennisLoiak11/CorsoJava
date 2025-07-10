package Settimana3.Martedi8Luglio;

interface Messaggio {
    String getContenuto();
}

class MessaggioBase implements Messaggio {

    @Override
    public String getContenuto() {
        return "ciao, questo è un messaggio di esempio.";
    }
}

abstract class DecoratoreMessaggio implements Messaggio {
    protected Messaggio messaggio;

    public DecoratoreMessaggio(Messaggio messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String getContenuto() {
        return messaggio.getContenuto();
    }
}

class DecoratoreMaiuscolo extends DecoratoreMessaggio {

    public DecoratoreMaiuscolo(Messaggio messaggio) {
        super(messaggio);
    }

    @Override
    public String getContenuto() {
        return super.getContenuto().toUpperCase();
    }
}

public class EsercizioDecorator {
    public static void main(String[] args) {
            Messaggio messaggio = new MessaggioBase();
            Messaggio messaggioDecorato = new DecoratoreMaiuscolo(messaggio);
            System.out.println("Messaggio originale: " + messaggio.getContenuto());
            System.out.println("Messaggio decorato: " + messaggioDecorato.getContenuto());
    }
}
