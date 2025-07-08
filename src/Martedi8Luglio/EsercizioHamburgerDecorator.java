package Martedi8Luglio;

interface Hamburger {
    String getDescrizione();
    double getPrezzo();
}

class BaseBurger implements Hamburger {

    @Override
    public String getDescrizione() {
        return "Hamburger base";
    }

    @Override
    public double getPrezzo() {
        return 3.50;
    }
}

abstract class HamburgerDecorator implements Hamburger {
    protected Hamburger hamburger;

    public HamburgerDecorator(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public String getDescrizione() {
        return hamburger.getDescrizione();
    }

    @Override
    public double getPrezzo() {
        return hamburger.getPrezzo();
    }
}

class FormaggioDecorator extends HamburgerDecorator {

    public FormaggioDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public String getDescrizione() {
        return hamburger.getDescrizione() + " + formaggio";
    }

    @Override
    public double getPrezzo() {
        return hamburger.getPrezzo() + 0.50;
    }
}

class BaconDecorator extends HamburgerDecorator {

    public BaconDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public String getDescrizione() {
        return hamburger.getDescrizione() + " + bacon";
    }

    @Override
    public double getPrezzo() {
        return hamburger.getPrezzo() + 0.80;
    }
}

public class EsercizioHamburgerDecorator {
    public static void main(String[] args) {
        Hamburger ordine = new BaseBurger();
        ordine = new FormaggioDecorator(ordine);
        ordine = new BaconDecorator(ordine);

        System.out.println("Ordine: " + ordine.getDescrizione());
        System.out.printf("Prezzo totale: %.2f€\n", ordine.getPrezzo());
    }
}