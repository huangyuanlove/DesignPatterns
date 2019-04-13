/**
 * 策略模式
 */
public class StrategyPatterns {

    public static void main(String[] args) {
        Environment enviroment = new Environment(new AddStrategy());
        System.out.println(enviroment.calc(1, 2));
        enviroment = new Environment(new SubtractStrategy());
        System.out.println(enviroment.calc(1, 2));
    }

}


interface Strategy {
    int calc(int a, int b);
}


class AddStrategy implements Strategy {

    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}

class SubtractStrategy implements Strategy {

    @Override
    public int calc(int a, int b) {
        return a - b;
    }
}


class Environment {
    private Strategy strategy;

    public Environment(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calc(int a, int b) {
        return strategy.calc(a, b);
    }
}