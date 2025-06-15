package lambdas;

@FunctionalInterface // Macht deutlich, dass dieses Interface genau eine abstrakte Methode hat
public interface MyInterface {
    public void message(String name, char symbol); // Eine Methode = Voraussetzung für Lambda
}
