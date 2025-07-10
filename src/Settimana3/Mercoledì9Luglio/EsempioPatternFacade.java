package Settimana3.Mercoledì9Luglio;

class SubsystemA {
    void operationA() {
        System.out.println("Operazione A del sottosistema A");
    }
}

class SubsystemB {
    void operationB() {
        System.out.println("Operazione B del sottosistema B");
    }
}

class Facade {
    private SubsystemA subsystemA = new SubsystemA();
    private SubsystemB subsystemB = new SubsystemB();

    public void operazioneUnificata() {
        subsystemA.operationA();
        subsystemB.operationB();
    }
}

public class EsempioPatternFacade {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operazioneUnificata();
    }
}
