package Settimana2.Lunedi30Giugno;

import java.util.ArrayList;

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

    // Il metodo prendiInPrestito() controlla se l'utente ha già tre libri, altrimenti fa aggiungere un altro libro a quelli già presi in prestito
    public void prendiInPrestito(Book libro) {
        if(libriInPrestito.size() < 3){
            libriInPrestito.add(libro);
        }else{
            System.out.println("L'utente " + name + " non può prendere in prestito altri libri");
        }
    }

    //Il metodo showUserBook() mostra tutti i libri di un utente se ne ha
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
            System.out.println("\n======================================");
            System.out.println("           Libri di " + name );
            System.out.println("======================================");
            System.out.println("Al momento " + name + " non possiede libri");
        }
    }

    //Il metodo returnBook() rimuove il libro da quelli presi in prestito dall'utente mettendolo disponibile nella biblioteca
    void returnBook(String title){
        Book libroDaRestituire = null;

        for (Book libro : libriInPrestito) {
            if (libro.title.equalsIgnoreCase(title)) {
                libroDaRestituire = libro;
                break;
            }
        }

        //Salvo l'oggetto da rimuovere dalla lista una volta che l'ArrayList non è più ciclato con il for each
        if (libroDaRestituire != null) {
            libriInPrestito.remove(libroDaRestituire);
            libroDaRestituire.isAvailable = true;
            System.out.println("\n======================================");
            System.out.println("Grazie per averci restituito " + title + " speriamo ti sia piaciuto. Arrivederci!");
        } else {
            System.out.println("Questo libro non lo hai preso da questa biblioteca.");
        }
    }
}

public class Library {
    ArrayList<Book> libri = new ArrayList<>();

    //Per aggiungere il libro alla libreria
    void addBook(Book book){
        libri.add(book);
    }

    //Visuallizzare tutti i libri nella libreria
    void displayBooks(){
        System.out.println("\n========== Elenco dei Libri ==========");
        if (libri.isEmpty()) {
            System.out.println("Nessun libro presente nella libreria.");
        } else {
            for (int i = 0; i < libri.size(); i++) {
                System.out.println("\nLIBRO #" + (i + 1));
                libri.get(i).displayBookInfo();
            }
        }
        System.out.println("======================================");
    }

    //Restituire un libro e assegnarlo a true
    void borrowBook(String title){
        for(Book libro : libri) {
            if (libro.title.equalsIgnoreCase(title)) {
                libro.isAvailable = false;
                System.out.println("Ecco a te " + title + " appena finisci di leggerlo potrai tornare qui per restituirlo. Buona lettura!");
            }
        }
        System.out.println("Mi dispiace il libro richiesto non è attualmente disponibile.");
    }

    //Mostra solo i libri disponibile nella libreria
    void showAvailableBooks(){
        for(Book book : libri){
            if(book.isAvailable == true){
                book.displayBookInfo();
            }else{
                System.out.println("Al momento non ci sono libri disponibili");
            }
        }
    }

    //Permette di controllare se un libro è disponibile tramite il titolo o l'autore
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

        //Creo più oggetti Book
        Book b1 = new Book("Harry Potter e la pietra filosofale", "J. K. Rowling", true);
        Book b2 = new Book("Diario di una schiappa", "Jeff Kinney", true);
        Book b3 = new Book("Geronimo Stilton: Il mistero dell’occhio di smeraldo", "Geronimo Stilton", true);
        Book b4 = new Book("Il Signore degli Anelli", "J. R. R. Tolkien", true);
        Book b5 = new Book("1984", "George Orwell", true);

        b1.displayBookInfo();

        //Aggiungo i libri alla libreria
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);
        library.addBook(b5);

        library.displayBooks();

        //Utilizzo i metodi definiti nella class User per interagire con i libri della libreria
        dennis.prendiInPrestito(b1);
        dennis.showUserBook();
        dennis.returnBook("Harry Potter e la pietra filosofale");
        dennis.showUserBook();
    }

}