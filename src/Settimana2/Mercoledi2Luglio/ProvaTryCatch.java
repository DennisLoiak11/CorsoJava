package Settimana2.Mercoledi2Luglio;

public class ProvaTryCatch {

    public static void main(String[] args) {
        try{
            int a = 5;
            int b = 0;
            int c = a / b;
            System.out.println(c);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("Finally");
        }
        System.out.println("Programma terminato");
    }
}
