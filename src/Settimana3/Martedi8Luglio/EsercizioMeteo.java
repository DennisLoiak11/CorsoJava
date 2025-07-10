package Settimana3.Martedi8Luglio;

import java.util.ArrayList;
import java.util.List;

class StazioneMeteo {
    private List<Display> displays = new ArrayList<>();
    private float temperatura;

    public void aggiungiDisplay(Display d) {
        displays.add(d);
    }

    public void rimuoviDisplay(Display d) {
        displays.remove(d);
    }

    public void notificaDisplay() {
        for (Display d : displays) {
            d.aggiorna(temperatura);
        }
    }

    public void setTemperatura(float t) {
        this.temperatura = t;
        notificaDisplay();
    }
}

interface Display {
    void aggiorna(float temperatura);
}

class DisplayConsole implements Display {
    @Override
    public void aggiorna(float temperatura) {
        System.out.println("Display Console - Temperatura: " + temperatura + "°C");
    }
}

class DisplayMobile implements Display {
    @Override
    public void aggiorna(float temperatura) {
        System.out.println("Display Mobile - Temperatura: " + temperatura + "°C");
    }
}

public class EsercizioMeteo {
    public static void main(String[] args) {
        StazioneMeteo stazione = new StazioneMeteo();
        Display d1 = new DisplayConsole();
        Display d2 = new DisplayMobile();

        stazione.aggiungiDisplay(d1);
        stazione.aggiungiDisplay(d2);

        stazione.setTemperatura(22.5f);
        stazione.setTemperatura(25.0f);
    }
}
