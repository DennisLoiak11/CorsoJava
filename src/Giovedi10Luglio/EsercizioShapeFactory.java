package Giovedi10Luglio;

import java.util.Scanner;

//interfaccia base tutte le forme devono saper "disegnare"
interface IShape {
    void draw();  // Metodo comune a tutte le forme
}

//classe concreta cerchio
class Circle implements IShape {
    @Override
    public void draw() {
        System.out.println("Disegno un cerchio.");
    }
}

//classe concreta quadrato
class Square implements IShape {
    @Override
    public void draw() {
        System.out.println("Disegno un quadrato.");
    }
}

//classe astratta con metodo factory astratto
abstract class ShapeCreator {
    // Metodo factory che restituisce una forma
    public abstract IShape createShape(String type);
}

//concreteShapeCreator che crea cerchi o quadrati
class ConcreteShapeCreator extends ShapeCreator {

    @Override
    public IShape createShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("square")) {
            return new Square();
        } else {
            System.out.println("Tipo di forma non valido.");
            return null;
        }
    }
}

public class EsercizioShapeFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //chiedo all’utente che forma vuole disegnare
        System.out.print("Quale forma vuoi disegnare? (circle/square): ");
        String input = scanner.nextLine();

        ShapeCreator creator = new ConcreteShapeCreator();

        IShape shape = creator.createShape(input);

        //controlla se la forma è valida e la disegna
        if (shape != null) {
            shape.draw();
        }

        scanner.close();
    }
}

