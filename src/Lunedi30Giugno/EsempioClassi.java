package Lunedi30Giugno;

class Auto{
    String marca;
    int anno;
    double prezzo;

    void mostraInfo(){
        System.out.println(this.marca + " - " + this.anno + " - " + this.prezzo);
    }
}

class Persona{
    String nome;
    String cognome;
    static int conteggio;

    public Persona(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
        conteggio ++;
    }

    static int contatore(){
        return conteggio;
    }
}

public class EsempioClassi {
    public static void main(String[] args) {

        Auto auto1 = new Auto();
        auto1.marca = "Audi";
        auto1.anno = 2018;
        auto1.prezzo = 23000.99;
        auto1.mostraInfo();

        Persona p1 = new Persona("Dennis", "De Biasi");
        Persona p2 = new Persona("Mario", "Rossi");
        System.out.println(Persona.contatore());

    }
}