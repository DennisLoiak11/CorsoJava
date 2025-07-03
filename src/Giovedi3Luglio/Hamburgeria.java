package Giovedi3Luglio;

import java.util.ArrayList;
import java.util.Scanner;

class Hamburger{
    private String nome;

    public Hamburger(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Metodo che verrà ereditato dalle sottoclassi di Hamburge così facendo this.getNome() assumerà ogni volta
    // il rispettivo valore in base all'oggetto specifico
    void prepara(){
        System.out.println("Preparazione " + this.getNome() + ": \n 1. Pane; \n 2. Carne; \n 3. Ketchup/Maionese ");
    }
}

class CheeseBurger extends Hamburger{
    public CheeseBurger(String nome) {
        super(nome);
    }

    void prepara(){
        System.out.println("Preparazione " + this.getNome() + ": \n 1. Pane; \n 2. Carne; \n 3. Formaggio; \n 4. Ketchup/Maionese ");
    }
}

class DoubleBacon extends Hamburger{
    public DoubleBacon(String nome) {
        super(nome);
    }

    void prepara(){
        System.out.println("Preparazione " + this.getNome() + ": \n 1. Pane; \n 2. Doppia carne; " +
                "\n 3. Bacon; \n 4. Cheddar; \n 5. Ketchup/Maionese ");
    }
}

class VegBurger extends Hamburger{
    public VegBurger(String nome) {
        super(nome);
    }

    void prepara(){
        System.out.println("Preparazione VegBurger: \n 1. Pane integrale; \n 2. Burger vegetale; " +
                "\n 3. Insalata; \n 4. Pomodoro ");
    }
}

public class Hamburgeria {
    public static void main(String[] args) {
        ArrayList<Hamburger> listaHamburger = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("\n🍔======= HAMBURGERIA Los Haburger Hermanos =======🍔");
            System.out.println("1. Nuovo ordine");
            System.out.println("2. Visualizza preparazione panini ordinati");
            System.out.println("3. Esci");
            System.out.print("- Scelta: ");

            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":
                    System.out.println("\n👉 Quale panino desideri?");
                    System.out.println("   a. CheeseBurger");
                    System.out.println("   b. VegBurger");
                    System.out.println("   c. DoubleBacon");
                    System.out.print("- Scelta: ");
                    String tipo = scanner.nextLine();

                    //Inizializzo l'oggetto panino a null così da poter definire il tipo specifico in base alla sottoclasse
                    Hamburger panino = null;
                    switch (tipo.toLowerCase()) {
                        case "a":
                            panino = new CheeseBurger("CheeseBurger");
                            break;
                        case "b":
                            panino = new VegBurger("VegBurger");
                            break;
                        case "c":
                            panino = new DoubleBacon("DoubleBacon");
                            break;
                        default:
                            System.out.println("❌ Scelta non valida.");
                            continue;
                    }
                    //Aggiungo il panino ordinato all'ArrayList di oggetti di tipo Hamburger
                    listaHamburger.add(panino);
                    System.out.println("✅ " + panino.getNome() + " aggiunto all'ordine!");
                    break;

                case "2":
                    //Se l'ArrayList di Hamburger è vuota comunico che non è stato ordinato nessun panino
                    if (listaHamburger.isEmpty()) {
                        System.out.println("⚠️ Nessun panino ordinato.");
                    } else {
                        System.out.println("\n🛠️ Preparazione in corso:");
                        for (Hamburger h : listaHamburger) {
                            System.out.println("\n👉 " + h.getNome() + ":");
                            h.prepara();
                        }
                    }
                    break;

                case "3":
                    System.out.println("\nGrazie per aver ordinato da Los Haburger Hermanos! 👋");
                    continua = false;
                    break;

                default:
                    //Scatta al momento della selezione della scelta dell'operazione nel caso in cui
                    // venga inserito un dato errato
                    System.out.println("❌ Scelta non valida. Riprova.");
            }
        }
    }
}
