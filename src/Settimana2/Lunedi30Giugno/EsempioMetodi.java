package Settimana2.Lunedi30Giugno;

class Calcolatrice{
    int somma(int a, int b){
        return a + b;
    }

    void saluta(){
        System.out.println("Ciao!");
    }
}

public class EsempioMetodi {
        public static void main(String[] args) {
            Calcolatrice calcolatrice = new Calcolatrice();
            calcolatrice.saluta();
            System.out.println(calcolatrice.somma(5, 6) );
    }
}