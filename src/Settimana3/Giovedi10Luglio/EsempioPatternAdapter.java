package Settimana3.Giovedi10Luglio;

interface Target {
    void request();
}

class Adaptee {
    void specificRequest() {
        System.out.println("Richiesta specifica eseguita.");
    }
}

class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}

public class EsempioPatternAdapter {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        adapter.request();
    }
}
