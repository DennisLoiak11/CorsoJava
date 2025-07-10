package Settimana3.Mercoledì9Luglio;

interface Strategy{
    void execute();
}

class ConcreteStrategyA implements Strategy{
    public void execute(){
        System.out.println("Strategia A eseguita");
    }
}

class ConcreteStrategyB implements Strategy{
    public void execute(){
        System.out.println("Strategia B eseguita");
    }
}

class Context{
    private Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void performTask(){
        strategy.execute();
    }
}

public class EsempioPatternStrategy {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.performTask();
        context.setStrategy(new ConcreteStrategyB());
        context.performTask();
    }
}
