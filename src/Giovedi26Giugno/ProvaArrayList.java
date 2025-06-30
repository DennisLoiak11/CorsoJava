import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProvaArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numeri = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            numeri.add((int) (Math.random() * 100 + 1));
        }
        System.out.println("Lista originale: " + numeri);
        Collections.sort(numeri);
        System.out.println("Lista ordinata: " + numeri);
    }
}
