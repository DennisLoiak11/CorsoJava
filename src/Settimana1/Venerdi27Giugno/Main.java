import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<String> nomi = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String nome;
        boolean continua = true;
        
        while(continua == true){
            System.out.print("Inserisci il nome dello studente che vuoi inserire: ");
            nome = scanner.nextLine();
            if(nome == "stop"){
                continua = false;
            }
            nomi.add(nome);
        }

        for(String n : nomi){
            System.out.println(n);
        }
    }
}
