package Settimana3.Mercoledì9Luglio;

class LuceCamera {
    public void accendi() {
        System.out.println("Luce della camera accesa.");
    }
}

class LuceCucina {
    public void accendi() {
        System.out.println("Luce della cucina accesa.");
    }
}

class GestioneLuciFacade {
    private LuceCamera camera = new LuceCamera();
    private LuceCucina cucina = new LuceCucina();

    public void accendiTutte() {
        camera.accendi();
        cucina.accendi();
    }
}

public class EsercizioFacade {
    public static void main(String[] args) {
        GestioneLuciFacade facade = new GestioneLuciFacade();
        facade.accendiTutte();  //accende tutte le luci con una sola chiamata
    }
}
