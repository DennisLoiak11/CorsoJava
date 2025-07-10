package Settimana3.Giovedi10Luglio;

interface EuropeanSocket {
    void giveElectricity();
}

//classe della presa americana ovvero quella che realmente fornisce la corrente
class AmericanSocket {
    public void provideElectricity() {
        System.out.println("Elettricità fornita da presa americana (110V).");
    }
}

//SockerAdapter converte una presa americana in una compatibile con una europea
class SocketAdapter implements EuropeanSocket {
    private AmericanSocket americanSocket;

    //l'adapter riceve una presa americana
    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    //il metodo atteso dal dispositivo europeo chiama quello della presa americana
    @Override
    public void giveElectricity() {
        System.out.println("Adattatore converte la presa...");
        americanSocket.provideElectricity();
    }
}

public class EsercizioPresaCorrente {
    public static void main(String[] args) {
        //creo una presa americana
        AmericanSocket presaAmericana = new AmericanSocket();

        //adattatore per renderla compatibile con una presa europea
        EuropeanSocket adattatore = new SocketAdapter(presaAmericana);

        //l'adattatore dispositivo europeo riceve elettricità tramite l'adattatore
        adattatore.giveElectricity();
    }
}