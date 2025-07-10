package Settimana2.Lunedi30Giugno;

public class ProvaModificatori {
    int quadrato(int n){
        return n * n;
    }

    static int cubo(int n){
        return n * n * n;
    }

    public static void main(String[] args) {
        System.out.println(ProvaModificatori.cubo(5) );
        ProvaModificatori provaModificatori = new ProvaModificatori();
        System.out.println(provaModificatori.quadrato(5));
    }

}
