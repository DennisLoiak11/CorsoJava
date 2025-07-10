import java.util.ArrayList;
import java.util.Collections;

public class EsercizioArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numeri = new ArrayList<>();
        ArrayList<Integer> numeri2 = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            numeri.add((int) (Math.random() * 10 + 1));
        }
        System.out.println("Lista originale: " + numeri);
        Collections.sort(numeri);
        System.out.println("Lista ordinata: " + numeri);

        numeri2.addAll(numeri);
        System.out.println("Lista originale 2: " + numeri2);
    }
}
