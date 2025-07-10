
import java.util.List;
import java.util.Scanner;

public class EsercizioFunzioni {
    
    static int potenza(int n){
        return n * n;
    }

    static int potenza(String a){
        return a.length();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero per calcolare la potenza: ");
        String str = scanner.nextLine();
        boolean isNum = true;
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                isNum = true;
            }else{
                isNum = false;
            }
        }
        if(isNum == true){
            System.out.println(potenza(Integer.parseInt(str)));
        }else{
            System.out.println(potenza(str));
        }
    }
}
