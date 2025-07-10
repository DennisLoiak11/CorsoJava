package Settimana2.Mercoledi2Luglio;

import java.util.ArrayList;

class Camera {
    private int numero;
    private float prezzo;

    public Camera(int numero, float prezzo) {
        this.numero = numero;
        this.prezzo = prezzo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    // Metodo senza parametri che stampa tutte le info della camera
    public void dettagli() {
        System.out.println("Camera numero: " + numero + ", Prezzo: " + prezzo);
    }

    // Metodo overload con parametro booleano per decidere se stampare anche il prezzo
    public void dettagli(boolean conPrezzo) {
        if (conPrezzo) {
            dettagli();
        } else {
            System.out.println("Camera numero: " + numero);
        }
    }
}

class Suite extends Camera {
    private String serviziExtra;

    public Suite(int numero, float prezzo, String serviziExtra) {
        super(numero, prezzo);
        this.serviziExtra = serviziExtra;
    }

    public String getServiziExtra() {
        return serviziExtra;
    }

    public void setServiziExtra(String serviziExtra) {
        this.serviziExtra = serviziExtra;
    }

    // Override del metodo dettagli per stampare anche i servizi extra della suite
    @Override
    public void dettagli() {
        super.dettagli();
        System.out.println("Servizi extra: " + serviziExtra);
    }

    // Override del metodo overload con parametro booleano per includere i servizi extra
    @Override
    public void dettagli(boolean conPrezzo) {
        super.dettagli(conPrezzo);
        System.out.println("Servizi extra: " + serviziExtra);
    }
}

class Hotel {
    private String nome;
    private ArrayList<Camera> listaCamere;

    public Hotel(String nome) {
        this.nome = nome;
        this.listaCamere = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void aggiungiCamera(Camera camera) {
        listaCamere.add(camera);
    }

    public ArrayList<Camera> getListaCamere() {
        return listaCamere;
    }

    // Metodo statico per contare quante suite ci sono nella lista di camere
    public static int contaSuite(ArrayList<Camera> lista) {
        int count = 0;
        for (Camera c : lista) {
            if (c instanceof Suite) { // Verifica se la camera è una Suite
                count++;
            }
        }
        return count;
    }
}

public class GestioneHotel {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Paradiso");

        // Aggiungo 2 camere normali
        Camera c1 = new Camera(101, 50.0f);
        Camera c2 = new Camera(102, 55.5f);

        // Aggiungo 2 suite con servizi extra
        Suite s1 = new Suite(201, 100.0f, "Jacuzzi, vista mare");
        Suite s2 = new Suite(202, 120.0f, "Balcone, colazione inclusa");

        hotel.aggiungiCamera(c1);
        hotel.aggiungiCamera(c2);
        hotel.aggiungiCamera(s1);
        hotel.aggiungiCamera(s2);

        // Uso il metodo dettagli() senza parametri per stampare tutte le info
        System.out.println("Dettagli camere (tutte le info):");
        for (Camera c : hotel.getListaCamere()) {
            c.dettagli();
            System.out.println();
        }

        // Uso il metodo overload dettagli(false) per stampare solo il numero della camera
        System.out.println("Dettagli camere (solo numero):");
        for (Camera c : hotel.getListaCamere()) {
            c.dettagli(false);
            System.out.println();
        }

        // Uso il metodo statico per contare quante suite ci sono nella lista
        int numeroSuite = Hotel.contaSuite(hotel.getListaCamere());
        System.out.println("Numero di suite nell'hotel: " + numeroSuite);
    }
}