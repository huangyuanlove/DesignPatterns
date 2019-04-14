/**
 * 责任链模式
 */
public class ChainOfResponsibilityPatterns {

    public static void main(String[] args) {
        Suppot alice = new NoSupport("Alice");
        Suppot bob = new LimitSupport("Bob",100);
        Suppot charlie = new SpecialSuppot("Charlie",429);
        Suppot diana = new LimitSupport("Diana",200);
        Suppot elmo = new OddSuppot("Elmo");
        Suppot fred = new LimitSupport("Fred",300);
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        for (int i = 0; i < 500; i+=12) {

            alice.support(new Trouble(i));
        }
    }

}


class Trouble{
    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "[Trouble " + number +"]";
    }
}

abstract class Suppot {
    private String name;
    private Suppot next;

    public Suppot(String name) {
        this.name = name;
    }

    public Suppot setNext(Suppot next) {
        this.next = next;
        return next;
    }

      abstract boolean resolve(Trouble trouble);
    void done(Trouble trouble){
        System.out.println(trouble + " is resolve by " + this);
    }

    void fail(Trouble trouble){
        System.out.println(trouble + " cannot be resolved");
    }

    public final void support(Trouble trouble){
        if(resolve(trouble)){

            done(trouble);
        }else if(next!=null){
            next.support(trouble);
        }else {
            fail(trouble);
        }
    }

    @Override
    public String toString() {
        return "[" +name +"]";
    }
}


class NoSupport extends Suppot{


    public NoSupport(String name) {
        super(name);
    }

    @Override
    boolean resolve(Trouble trouble) {
        return false;
    }
}


class LimitSupport extends Suppot{
    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    boolean resolve(Trouble trouble) {
        return trouble.getNumber()<limit;
    }
}

class OddSuppot extends Suppot{

    public OddSuppot(String name) {
        super(name);
    }

    @Override
    boolean resolve(Trouble trouble) {
        return trouble.getNumber() %2 ==1;
    }
}

class SpecialSuppot extends Suppot{
    private int number;

    public SpecialSuppot(String name, int number) {
        super(name);
        this.number = number;
    }


    @Override
    boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }
}