package Mercoledi2Luglio;

import java.util.ArrayList;
import java.util.Scanner;

class Animale {
    protected String nome;
    protected int eta;

    public Animale(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    void faiVerso() {
        System.out.println("fai verso...");
    }
}

class Cane extends Animale {
    public Cane(String nome, int eta) {
        super(nome, eta);
    }

    void faiVerso() {
        System.out.println("bau bau");
    }
}

class Gatto extends Animale {
    public Gatto(String nome, int eta) {
        super(nome, eta);
    }

    void faiVerso() {
        System.out.println("miao miao");
    }
}

public class EsercizioZoo {
    public static void main(String[] args) {
        ArrayList<Animale> animali = new ArrayList<>();
        //Inserisco lo scanner nelle parentesi del try with resources così si chiude in automatico al termine
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continua = true;

            while (continua) {
                System.out.println("\n---- MENU ----");
                System.out.println("1. Aggiungi Cane");
                System.out.println("2. Aggiungi Gatto");
                System.out.println("3. Visualizza tutti gli animali");
                System.out.println("4. Esci");
                System.out.print("Scelta: ");

                String scelta = scanner.nextLine();

                switch (scelta) {
                    case "1":
                        System.out.print("Inserisci il nome del cane: ");
                        String nomeCane = scanner.nextLine();
                        System.out.print("Inserisci l'età del cane: ");
                        try {
                            int etaCane = Integer.parseInt(scanner.nextLine());
                            animali.add(new Cane(nomeCane, etaCane));
                        } catch (NumberFormatException e) {
                            System.out.println("Età non valida. Inserisci un numero intero.");
                        }
                        break;

                    case "2":
                        System.out.print("Inserisci il nome del gatto: ");
                        String nomeGatto = scanner.nextLine();
                        System.out.print("Inserisci l'età del gatto: ");
                        try {
                            int etaGatto = Integer.parseInt(scanner.nextLine());
                            animali.add(new Gatto(nomeGatto, etaGatto));
                        } catch (NumberFormatException e) {
                            System.out.println("Età non valida. Inserisci un numero intero.");
                        }
                        break;

                    case "3":
                        if (animali.isEmpty()) {
                            System.out.println("Nessun animale presente.");
                        } else {
                            for (Animale animale : animali) {
                                System.out.print("Nome: " + animale.nome + ", Età: " + animale.eta + ", Verso: ");
                                animale.faiVerso();
                            }
                        }
                        break;

                    case "4":
                        continua = false;
                        System.out.println("Zoo chiuso. Arrivederci");
                        break;

                    default:
                        System.out.println("Scelta non valida. Riprova inserendo un numero.");
                }
            }
        }
    }
}