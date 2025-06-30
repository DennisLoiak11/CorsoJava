import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaSpesa = new ArrayList<>();

        System.out.println("Inserisci gli articoli della spesa (scrivi 'fine' per terminare):");

        while (true) {
            String articolo = scanner.nextLine().toLowerCase(); // per confronto case-insensitive

            if (articolo.equals("fine")) {
                break;
            }

            listaSpesa.add(articolo);
        }

        // Stampa tutti gli elementi
        System.out.println("Articoli inseriti:");
        for (String item : listaSpesa) {
            System.out.println("- " + item);
        }

        // Numero totale di elementi
        System.out.println("Numero totale di articoli: " + listaSpesa.size());

        // Controlla se contiene "pane" e "latte"
        if (listaSpesa.contains("pane") && listaSpesa.contains("latte")) {
            System.out.println("Hai pensato alla colazione!");
        }

        scanner.close();
    }
}
