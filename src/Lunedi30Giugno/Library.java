package Lunedi30Giugno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book{
    String title;
    String author;
    boolean isAvailable;

    //Costruttore per inizializzare le variabili al momento dell'istanza dell'oggetto Book
    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    //Metodo per visualizzare tutte le informazione realitve ad un singolo libro
    public void displayBookInfo() {
        System.out.println("======================================");
        System.out.println("          Informazioni Libro       ");
        System.out.println("======================================");
        System.out.println("Titolo      : " + title);
        System.out.println("Autore      : " + author);
        System.out.println("Disponibile : " + (isAvailable ? "Sì" : "No"));
    }

}

class User{
    String name;
    ArrayList<Book> libriInPrestito;

    public User(String name) {
        this.name = name;
        this.libriInPrestito = new ArrayList<>();
    }

    public void prendiInPrestito(Book libro) {
        if(libriInPrestito.size() < 3){
            libriInPrestito.add(libro);
        }else{
            System.out.println("L'utente " + name + " non può prendere in prestito altri libri");
        }
    }

    public void restituisciLibro(Book libro) {
        libriInPrestito.remove(libro);
    }

    void showUserBook(){
        if(libriInPrestito.size() > 0){
            for(Book book : libriInPrestito){
                System.out.println("======================================");
                System.out.println("           Libri di " + name );
                System.out.println("======================================");
                System.out.println("Titolo      : " + book.title);
                System.out.println("Autore      : " + book.author);
                System.out.println("Disponibile : " + (book.isAvailable ? "Sì" : "No"));
            }
        }else {
            System.out.println("======================================");
            System.out.println("           Libri di " + name );
            System.out.println("======================================");
            System.out.println("Al momento " + name + " non possiede libri");
        }
    }

    void returnBook(String title){
        for(Book libro : libriInPrestito) {
            if (libro.title.equalsIgnoreCase(title)) {
                libro.isAvailable = true;
                System.out.println("Grazie per averci restituito " + title + " speriamo ti sia piaciuto. Arrivederci!");
            }
        }
        System.out.println("Questo libro non lo hai preso da questo biblioteca.");
    }
}

public class Library {
    ArrayList<Book> libri = new ArrayList<>();

    void addBook(Book book){
        libri.add(book);
    }

    void displayBooks(){
        System.out.println("\n========== Elenco dei Libri ==========");
        if (libri.isEmpty()) {
            System.out.println("Nessun libro presente nella libreria.");
        } else {
            for (int i = 0; i < libri.size(); i++) {
                System.out.println("LIBRO #" + (i + 1));
                libri.get(i).displayBookInfo();
            }
        }
        System.out.println("======================================");
    }

    void borrowBook(String title){
        for(Book libro : libri) {
            if (libro.title.equalsIgnoreCase(title)) {
                libro.isAvailable = false;
                System.out.println("Ecco a te " + title + " appena finisci di leggerlo potrai tornare qui per restituirlo. Buona lettura!");
            }
        }
        System.out.println("Mi dispiace il libro richiesto non è attualmente disponibile.");
    }

    void showAvailableBooks(){
        for(Book book : libri){
            if(book.isAvailable == true){
                book.displayBookInfo();
            }else{
                System.out.println("Al momento non ci sono libri disponibili");
            }
        }
    }

    void searchBook(String keyword){
        for(Book libro : libri){
            if (libro.title.equalsIgnoreCase(keyword) || libro.author.equalsIgnoreCase(keyword)){
                libro.displayBookInfo();
            }else{
                System.out.println("Al momento non c'è nessun libro come quello che hai chiesto");
            }
        }
    }

    public static void main(String[] args) {
        User dennis = new User("Dennis");
        Library library = new Library();
        Book b1 = new Book("Harry Potter e la pietra filosofale", "J. K. Rowling", true);

        b1.displayBookInfo();
        library.addBook(b1);
        //library.displayBooks();
        //library.borrowBook("Diario di una schiappa");
        dennis.prendiInPrestito(b1);
        dennis.showUserBook();
    }

}