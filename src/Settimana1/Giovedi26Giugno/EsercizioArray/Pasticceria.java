package EsercizioArray;

import java.util.Scanner;

public class Pasticceria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int massimoDolci = 10;
        System.out.print("Quanti dolci vuoi? ");
        int quantitaDolci = scanner.nextInt();
        String[] nomeDolce = new String[quantitaDolci];
        int[] numeroDolce = new int[nomeDolce.length];

        if (quantitaDolci > massimoDolci){
            System.out.println("Puoi ordinare al massimo 10 dolci diversi.");

        }

        if(quantitaDolci > 0){
            for (int i = 0; i < nomeDolce.length; i++){
                System.out.print("Quale dolce vuoi? ");
                nomeDolce[i] = scanner.next();
                System.out.print("Quante porzioni di " + nomeDolce[i].toLowerCase() + " vuoi? ");
                numeroDolce[i] = scanner.nextInt();
            }

            for(int i = 0; i < nomeDolce.length; i++){
                System.out.print(numeroDolce[i] + " porzioni di " + nomeDolce[i].toLowerCase() + ", ");
            }
        }
    }
}
