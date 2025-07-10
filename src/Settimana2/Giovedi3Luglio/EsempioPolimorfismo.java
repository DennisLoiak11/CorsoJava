package Settimana2.Giovedi3Luglio;

class Persona{
    void saluta(){
        System.out.println("Ciao sono una Persona");
    }
}

class Pirata extends Persona{
    void saluta(){
        System.out.println("Ciao sono un Pirata, aaargh!");
    }
}

public class EsempioPolimorfismo {
    public static void main(String[] args) {
        Persona p = new Persona();
        Pirata pirata = new Pirata();
        p.saluta();
        pirata.saluta();
    }
}
