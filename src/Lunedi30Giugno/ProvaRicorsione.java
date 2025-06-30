package Lunedi30Giugno;

public class ProvaRicorsione {

    static String saluto(String s){
        if(s == "Ciao") return saluto(s + " Dennis");
        return s;
    }

    public static void main(String[] args) {
        System.out.println(saluto("Ciao"));
    }

}
