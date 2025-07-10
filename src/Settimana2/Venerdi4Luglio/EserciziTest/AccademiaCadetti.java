package Settimana2.Venerdi4Luglio.EserciziTest;

import java.util.Scanner;

public class AccademiaCadetti {

    static class Cadetto {
        protected String nome;

        public Cadetto(String nome) {
            this.nome = nome;
        }

        public void presentati() {
            System.out.println("Sono un cadetto generico. Nome: " + nome);
        }
    }

    static class CadettoPilota extends Cadetto {
        private String navetta;

        public CadettoPilota(String nome, String navetta) {
            super(nome);
            this.navetta = navetta;
        }

        @Override
        public void presentati() {
            System.out.println("Sono il cadetto pilota " + nome + ", assegnato alla navetta: " + navetta);
        }
    }

    static class CadettoTecnico extends Cadetto {
        private String reparto;

        public CadettoTecnico(String nome, String reparto) {
            super(nome);
            this.reparto = reparto;
        }

        @Override
        public void presentati() {
            System.out.println("Sono il cadetto tecnico " + nome + ", reparto: " + reparto);
        }
    }

    static class CadettoMedico extends Cadetto {
        private String specializzazione;

        public CadettoMedico(String nome, String specializzazione) {
            super(nome);
            this.specializzazione = specializzazione;
        }

        @Override
        public void presentati() {
            System.out.println("Sono il cadetto medico " + nome + ", specializzazione: " + specializzazione);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cadetto cadetto;

        System.out.print("Inserisci il nome del cadetto: ");
        String nome = scanner.nextLine();

        System.out.println("Scegli il tipo di cadetto:");
        System.out.println("1. Pilota");
        System.out.println("2. Tecnico");
        System.out.println("3. Medico");
        System.out.print("Scelta: ");
        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta) {
            case 1:
                System.out.print("Inserisci il nome della navetta: ");
                String navetta = scanner.nextLine();
                cadetto = new CadettoPilota(nome, navetta);
                break;
            case 2:
                System.out.print("Inserisci il nome del reparto tecnico: ");
                String reparto = scanner.nextLine();
                cadetto = new CadettoTecnico(nome, reparto);
                break;
            case 3:
                System.out.print("Inserisci la specializzazione medica: ");
                String specializzazione = scanner.nextLine();
                cadetto = new CadettoMedico(nome, specializzazione);
                break;
            default:
                System.out.println("Scelta non valida. Verrà creato un cadetto generico.");
                cadetto = new Cadetto(nome);
        }

        System.out.println();
        cadetto.presentati();
    }
}

