package Settimana2.Giovedi3Luglio;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Astronauta{
    private String nome;
    private String email;
    private float creditoOssigeno;

    public Astronauta(String nome, String email) {
        this.nome = nome;
        this.email = email;
        //valore casuale di creditoOssigeno tra 50 e 100
        Random rand = new Random();
        this.creditoOssigeno = 50 + rand.nextFloat() * 50;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getCreditoOssigeno() {
        return creditoOssigeno;
    }

    public void setCreditoOssigeno(float creditoOssigeno) {
        this.creditoOssigeno = creditoOssigeno;
    }

    @Override
    public String toString() {
        return "Astronauta{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", creditoOssigeno=" + creditoOssigeno +
                '}';
    }
}

class Scienziato extends Astronauta{
    private int contatore;
    public Scienziato(String nome, String email) {
        super(nome, email);
        this.contatore = 0;
    }

    @Override
    public String toString() {
        return "Scienziato \n Nome: " + this.getNome() + " Email: " + this.getEmail()
                + " Ossigeno rimanente: " + this.getCreditoOssigeno();
    }

    public ScienziatoCapo addEsperimento(String esperimento, ArrayList<String> esperimenti){
        contatore++;
        if(contatore < 3){
            esperimenti.add(esperimento);
            System.out.println("L'esperimento " + esperimento + " è stato aggiunto alla lista di esperimenti");
            return null;
        } else {
            System.out.println("Complimenti per la promozione a Scienziato capo!");
            return new ScienziatoCapo(this.getNome(), this.getEmail(), true);
        }
    }
}

class ScienziatoCapo extends Scienziato{
    private boolean isScienziatoCapo;
    public ScienziatoCapo(String nome, String email, boolean isScienziatoCapo) {
        super(nome, email);
        this.isScienziatoCapo = isScienziatoCapo;
    }
    public boolean isScienziatoCapo() {
        return isScienziatoCapo;
    }

    public void setScienziatoCapo(boolean scienziatoCapo) {
        isScienziatoCapo = scienziatoCapo;
    }

    public void stampaEsperimenti(ArrayList<String> esperimenti) {
        System.out.println("Esperimenti registrati:");
        for(String e : esperimenti) {
            System.out.println("- " + e);
        }
    }
}

class Ispettore extends Astronauta{
    private int contatore;
    public Ispettore(String nome, String email) {
        super(nome, email);
        this.contatore = 0;
    }

    @Override
    public String toString() {
        return "Ispettore \n Nome: " + this.getNome() + " Email: " + this.getEmail()
                + " Ossigeno rimanente: " + this.getCreditoOssigeno();
    }

    public IspettoreEsperto addValutazione(int valutazione, ArrayList<Integer> valutazioni){
        contatore++;
        if(contatore < 3){
            valutazioni.add(valutazione);
            System.out.println("Valutazione:  " + valutazione + " aggiunta correttamente alla lista");
            return null;
        } else {
            System.out.println("Complimenti per la promozione a Ispettore esperto!");
            return new IspettoreEsperto(this.getNome(), this.getEmail(), true);
        }
    }
}

class IspettoreEsperto extends Ispettore{
    private boolean isIspettoreEsperto;
    public IspettoreEsperto(String nome, String email, boolean isIspettoreEsperto) {
        super(nome, email);
        this.isIspettoreEsperto = isIspettoreEsperto;
    }

    public void stampaValutazioni(ArrayList<Integer> valutazioni) {
        System.out.println("Valutazioni registrate:");
        for(int v : valutazioni) {
            System.out.println("- " + v);
        }
    }
}

class StazioneSpaziale{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Astronauta scienziato = null;
        Astronauta ispettore = null;
        ArrayList<String> esperimenti = new ArrayList<>();
        ArrayList<Integer> valutazioni = new ArrayList<>();

        while(true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Crea nuovo astronauta");
            System.out.println("2. Visualizza dati astronauta");
            System.out.println("3. Rientro/login (rigenera ossigeno)");
            System.out.println("4. Interagisci con il profilo");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");
            String input = scanner.nextLine();
            int scelta = 0;
            try {
                scelta = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Inserisci un numero intero.");
                continue;
            }

            switch(scelta) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Tipo (1 = Scienziato, 2 = Ispettore): ");
                    String tipoStr = scanner.nextLine();
                    int tipo = 0;
                    try {
                        tipo = Integer.parseInt(tipoStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Tipo non valido");
                        break;
                    }
                    if(tipo == 1) scienziato = new Scienziato(nome, email);
                    else if(tipo == 2) ispettore = new Ispettore(nome, email);
                    else System.out.println("Tipo non valido");
                    break;

                case 2:
                    if(scienziato != null) System.out.println(scienziato.toString());
                    if(ispettore != null) System.out.println(ispettore.toString());
                    if(scienziato == null && ispettore == null) System.out.println("Nessun astronauta creato.");
                    break;

                case 3:
                    if(scienziato != null)
                        scienziato.setCreditoOssigeno(50 + new Random().nextFloat() * 50);
                    if(ispettore != null)
                        ispettore.setCreditoOssigeno(50 + new Random().nextFloat() * 50);
                    if(scienziato == null && ispettore == null)
                        System.out.println("Nessun astronauta da rigenerare.");
                    break;

                case 4:
                    System.out.println("Con chi vuoi interagire? (1 = Scienziato, 2 = Ispettore): ");
                    String sceltaProfiloStr = scanner.nextLine();
                    int sceltaProfilo = 0;
                    try {
                        sceltaProfilo = Integer.parseInt(sceltaProfiloStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Scelta non valida.");
                        break;
                    }

                    if(sceltaProfilo == 1 && scienziato != null) {
                        if(scienziato instanceof ScienziatoCapo) {
                            ((ScienziatoCapo) scienziato).stampaEsperimenti(esperimenti);
                        } else {
                            System.out.print("Inserisci esperimento: ");
                            String e = scanner.nextLine();
                            ScienziatoCapo nuovo = ((Scienziato) scienziato).addEsperimento(e, esperimenti);
                            if(nuovo != null) scienziato = nuovo;
                        }
                    } else if(sceltaProfilo == 2 && ispettore != null) {
                        if(ispettore instanceof IspettoreEsperto) {
                            ((IspettoreEsperto) ispettore).stampaValutazioni(valutazioni);
                        } else {
                            System.out.print("Inserisci valutazione (1-5): ");
                            String valStr = scanner.nextLine();
                            int v = 0;
                            try {
                                v = Integer.parseInt(valStr);
                            } catch (NumberFormatException e) {
                                System.out.println("Valutazione non valida.");
                                break;
                            }
                            IspettoreEsperto nuovo = ((Ispettore) ispettore).addValutazione(v, valutazioni);
                            if(nuovo != null) ispettore = nuovo;
                        }
                    } else {
                        System.out.println("Profilo non disponibile.");
                    }
                    break;

                case 5:
                    System.out.println("Uscita dal programma.");
                    return;

                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}

public class MissioneSpaziale {
}
