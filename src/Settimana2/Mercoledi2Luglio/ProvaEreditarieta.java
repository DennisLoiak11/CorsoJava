package Settimana2.Mercoledi2Luglio;

class Vehicle{
    protected String brand = "Ford";
    public void honk(){
        System.out.println("BEEP, BEEEEP!!");
    }
}

class Car extends Vehicle{
    private String modelName = "Fiat";
}

public class ProvaEreditarieta {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.honk();//BEEP, BEEEEP!!
    }
}
