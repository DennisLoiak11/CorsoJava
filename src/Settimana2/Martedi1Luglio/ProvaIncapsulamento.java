package Settimana2.Martedi1Luglio;

class Person{
    private String nome;

    Person(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}

class User{
    private String nome;
    private int eta;

    public User(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    private boolean isMaggiorenne(){
        return this.eta > 18;
    }

    public void verificaEta() {
        if (isMaggiorenne()) {
            System.out.println(this.nome + " è maggiorenne");
        } else {
            System.out.println(this.nome + " è minorenne");
        }
    }
}

public class ProvaIncapsulamento {

    public static void main(String[] args) {
        Person person = new Person("Dennis");
        User user = new User("Francesco", 45);

        System.out.println(person.getNome());
        person.setNome("Daniele");
        System.out.println(person.getNome());
        user.verificaEta();
    }
}
