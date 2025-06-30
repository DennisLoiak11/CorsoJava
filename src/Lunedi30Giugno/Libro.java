package Lunedi30Giugno;

public class Libro {
    String titolo;
    String autore;
    double prezzo;
    static int codice_numerico_autoincrementante;

    public Libro(String titolo, String autore, double prezzo){
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
        codice_numerico_autoincrementante++;
    }

    public String toString(){
        return titolo + " - " + autore + " - " + prezzo + "$";
    }

    public static void contatore(){
        System.out.println("Totale libri creati: " + codice_numerico_autoincrementante);
    }


    public static void main(String[] args) {
        Libro l1 = new Libro("Harry Potter e la camera dei segreti", "J. K. Rowling", 30.99);
        System.out.println(l1);
        Libro l2 = new Libro("Tutte le barzellette su Totti", "Francesco Totti", 100.99);
        System.out.println(l2);
        Libro l3 = new Libro("Diario di una schiappa", "Jeff Kinney", 25.99);
        System.out.println(l3);

        Libro.contatore();
    }
}