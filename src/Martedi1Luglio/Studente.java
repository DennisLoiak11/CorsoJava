package Martedi1Luglio;

import java.util.ArrayList;

public class Studente {
    private static int id;
    private String nome;
    private int voto;

    public Studente(String nome, int voto) {
        this.nome = nome;
        this.voto = voto;
        id++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        if(voto >= 0 && voto <= 10){
            this.voto = voto;
        }else{
            System.out.println("Errore, " + voto + " non è valido come valore");
        }
    }

    public static void cercaStudente(String nome, ArrayList<Studente> studenti) {
        for (Studente s : studenti) {
            if (s.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Dati studente   -> Nome: " + s.getNome() + ", " + " Voto: " + s.getVoto());
            }
        }
        System.out.println("Non ci sono studenti che si chiamano " + nome);
    }

    private boolean isPromosso(){
        return this.voto >= 6;
    }

    public void verdettoFinale(){
        if(isPromosso()){
            System.out.println("\n======== Verdetto fine anno " + this.nome + " ========");
            System.out.println("Complimenti per la tua promozione " + this.nome + " adesso goditi le vacanze!");
        }else{
            System.out.println("\n======== Verdetto fine anno di " + this.nome + " ========");
            System.out.println("Brutte notizie "  + this.nome + " dovrai ripetere l'anno");
        }
    }

    public static void main(String[] args) {
        ArrayList<Studente> listaStudenti = new ArrayList<>();
        Studente studente1 = new Studente("Dennis", 3);
        Studente studente2 = new Studente("Francesco", 10);
        Studente studente3 = new Studente("Lorenzo", 7);
        Studente studente4 = new Studente("Kevin", 6);
        Studente studente5 = new Studente("Gianluca", 2);
        listaStudenti.add(studente1);
        listaStudenti.add(studente2);
        listaStudenti.add(studente3);
        listaStudenti.add(studente4);
        listaStudenti.add(studente5);
        for (Studente studente : listaStudenti){
            System.out.println("Dati studente -> Nome: " + studente.getNome() + ", " + " Voto: " + studente.getVoto());
        }

        for (Studente studente : listaStudenti){
            studente.verdettoFinale();
        }


        //studente1.setNome("Francesco");
        //studente1.setVoto(10);
        //System.out.println("Dati modificati -> Nome: " + studente1.getNome() + ", " + " Voto: " + studente1.getVoto());
    }

}
