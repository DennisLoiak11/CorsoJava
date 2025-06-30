public class ProvaFunzioni {
    
    static void saluta(){
        System.out.println("Ciao sono una funzione");
    }

    static int somma(int a, int b){
        return a + b;
    }

    //Overloading
    static void mostra(int a){
        System.out.println("Numero: " + a);
    }

    static void mostra(String str){
        System.out.println("Stringa: " + str);
    }

    public static void main(String[] args){
        saluta();
        System.out.println(somma(5, 3));
        mostra(52);
        mostra("Ciao");
    }
}
