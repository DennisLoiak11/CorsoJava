package Settimana3.Giovedi10Luglio;

import java.util.Scanner;

interface IVeicolo {
    void avvia();
    void mostraTipo();
}

class Auto implements IVeicolo {
    @Override
    public void avvia() {
        System.out.println("Avvio dell'auto");
    }

    @Override
    public void mostraTipo() {
        System.out.println("Tipo: Auto");
    }
}

class Moto implements IVeicolo {
    @Override
    public void avvia() {
        System.out.println("Avvio della moto");
    }

    @Override
    public void mostraTipo() {
        System.out.println("Tipo: Moto");
    }
}

class Camion implements IVeicolo {
    @Override
    public void avvia() {
        System.out.println("Avvio del camion");
    }

    @Override
    public void mostraTipo() {
        System.out.println("Tipo: Camion");
    }
}

class VeicoloFactory {
    public static IVeicolo creaVeicolo(String tipo) {
        if (tipo.equals("auto")) {
            return new Auto();
        } else if (tipo.equals("moto")) {
            return new Moto();
        } else if (tipo.equals("camion")) {
            return new Camion();
        } else {
            System.out.println("Tipo di veicolo non valido.");
            return null;
        }
    }
}

public class EsercizioFactoryMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il tipo di veicolo (auto, moto, camion): ");
        String tipo = scanner.nextLine();

        IVeicolo veicolo = VeicoloFactory.creaVeicolo(tipo);

        if (veicolo != null) {
            veicolo.avvia();
            veicolo.mostraTipo();
        }
        scanner.close();
    }
}
