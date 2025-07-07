package Lunedi7Luglio;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Persona{
    private String nome;
    private int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getEta(){
        return eta;
    }

    public void setEta(int eta){
        this.eta = eta;
    }
    //Metodo astratto che verrà implementato nelle classi concrete
    public abstract void descriviRuolo();
}

interface Registrabile{
    void registrazione();
}

class Studente extends Persona implements Registrabile{
    private String classeFrequentata;

    Studente(String nome, int eta, String classeFrequentata){
        super(nome, eta);
        this.classeFrequentata = classeFrequentata;
    }

    public String getClasseFrequentata() {
        return classeFrequentata;
    }

    public void setClasseFrequentata(String classeFrequentata) {
        this.classeFrequentata = classeFrequentata;
    }

    public void descriviRuolo(){
        System.out.println("Ciao, mi chiamo " + this.getNome() + " e sono uno studente di " + this.getEta() + " anni della classe " + this.getClasseFrequentata() + ".");
    }

    public void registrazione(){
        System.out.println("Registrazione effetuata tramite modulo online");
    }
}

class Docente extends Persona implements Registrabile{
    private String materia;

    Docente(String nome, int eta, String materia){
        super(nome, eta);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void descriviRuolo(){
        System.out.println("Ciao, mi chiamo " + this.getNome() + ", sono uno docente di " + this.getEta() + " e insegno " + this.getMateria().toLowerCase() + ".");
    }

    public void registrazione(){
        System.out.println("Registrazione effetuata tramite segreteria didattica");
    }

}

public class GestioneScuola {
    public static void main(String[] args) {
        ArrayList<Persona> listaPersone = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("\n======= Scuola superiore  =======");
            System.out.println("1. Nuova persona");
            System.out.println("2. Descrivi ruoli");
            System.out.println("3. Registra studenti e docenti");
            System.out.println("0. Esci");
            System.out.print("- Scelta: ");

            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":
                    System.out.println("\n- Quale persona vuoi creare?");
                    System.out.println("   a. Studente");
                    System.out.println("   b. Docente");
                    System.out.print("- Scelta: ");
                    String tipo = scanner.nextLine();

                    //Inizializzo l'oggetto persona a null così da poter definire il tipo specifico in base alla sottoclasse
                    Persona persona = null;
                    switch (tipo.toLowerCase()) {
                        case "a":
                            System.out.print("Inserisci il nome dello studente che vuoi creare: ");
                            String nomeStudente = scanner.nextLine();
                            System.out.print("Inserisci l'età dello studente: ");
                            int etaStudente = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Inserisci la classe dello studente: ");
                            String classe = scanner.nextLine();
                            persona = new Studente(nomeStudente, etaStudente, classe);
                            break;
                        case "b":
                            System.out.print("Inserisci il nome del docente che vuoi creare: ");
                            String nomeDocente = scanner.nextLine();
                            System.out.print("Inserisci l'età del docente: ");
                            int etaDocente = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Inserisci la materia insegnata dal docente: ");
                            String materia = scanner.nextLine();
                            persona = new Studente(nomeDocente, etaDocente, materia);
                            break;
                        default:
                            System.out.println("Scelta non valida.");
                            continue;
                    }
                    //Aggiungo lo studente o il docente creato all'ArrayList di oggetti di tipo Persona
                    listaPersone.add(persona);
                    System.out.println(persona.getNome() + " è stato aggiunto correttamente alla lista");
                    break;

                case "2":
                    for (Persona p : listaPersone) {
                        p.descriviRuolo();
                    }
                    break;

                case "3":
                    for (Persona p : listaPersone) {
                        if (p instanceof Registrabile) {
                            ((Registrabile) p).registrazione();
                        }
                    }
                    break;

                case "0":
                    System.out.println("\nArrivederci e grazie!");
                    continua = false;
                    break;

                default:
                    //Scatta al momento della selezione della scelta dell'operazione nel caso in cui
                    // venga inserito un dato errato
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}