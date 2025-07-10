package Settimana3.Giovedi10Luglio;

//patern Singleton per il Bios per renderlo unico per ogni sistema
class Bios {
    private static Bios instance;

    private Bios() {}

    public static Bios getInstance() {
        if (instance == null) {
            instance = new Bios();
        }
        return instance;
    }

    public void inizializza() {
        System.out.println("BIOS inizializzato.");
    }
}

class HardDisk {
    public void carica() {
        System.out.println("Hard Disk caricato.");
    }
}

//pattern Strategy
interface SistemaOperativo {
    void avvia();
}

class Windows implements SistemaOperativo {
    @Override
    public void avvia() {
        System.out.println("Windows avviato.");
    }
}

class Linux implements SistemaOperativo {
    @Override
    public void avvia() {
        System.out.println("Linux avviato.");
    }
}

class ComputerFacade {
    private Bios bios;
    private HardDisk hardDisk;
    private SistemaOperativo sistemaOperativo;

    public ComputerFacade(SistemaOperativo sistemaOperativo) {
        this.bios = Bios.getInstance();
        this.hardDisk = new HardDisk();
        this.sistemaOperativo = sistemaOperativo;
    }

    public void accendiComputer() {
        bios.inizializza();
        hardDisk.carica();
        sistemaOperativo.avvia();
    }
}

public class EsercizioMedioFacade {
    public static void main(String[] args) {
        //pattern strategy per cambiare sistema operativo facilmente
        SistemaOperativo windows = new Windows();
        //pattern facade per avviare il sistema intero
        ComputerFacade pc = new ComputerFacade(windows);
        pc.accendiComputer();
    }
}
