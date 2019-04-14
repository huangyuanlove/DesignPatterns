import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *观察者模式
 */
public class ObserverPatterns {

    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();

        generator.addObserver(observer1);
        generator.addObserver(observer2);

        generator.execute();
    }

}

interface Observer{
    void update(NumberGenerator generator);
}

abstract class NumberGenerator{

    private ArrayList<Observer> observerList = new ArrayList();

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void deleteObserver(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObservers(){
        Iterator<Observer> it = observerList.iterator();
        while (it.hasNext()){
            Observer o = it.next();
            o.update(this);
        }
    }

    public abstract int getNumber();
    public abstract void execute();

}

class RandomNumberGenerator extends NumberGenerator{
    private Random random= new Random();
    private int number;


    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}

class DigitObserver implements  Observer{

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.getNumber());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class GraphObserver implements Observer{

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("GraphObserver");
        int count = generator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}