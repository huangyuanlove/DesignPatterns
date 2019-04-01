import java.util.HashMap;

/**
 * 原型模式
 */
public class PrototypePatterns {

    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        ManagerBox mbox = new ManagerBox('*');
        ManagerBox sbox = new ManagerBox('/');

        manager.register("strong message",upen);
        manager.register("warning box",mbox);
        manager.register("slash box",sbox);

        Products p1 = manager.create("strong message");
        p1.use("Hello world");
        Products p2 = manager.create("warning box");
        p2.use("Hello world");
        Products p3 = manager.create("slash box");
        p3.use("Hello world");




    }

}


interface Products extends Cloneable{
     void use(String s);
      Products createClone();
}

class Manager{
    private HashMap<String, Products> showCase = new HashMap<>();

    public void register(String name,Products proto){
        showCase.put(name,proto);
    }

    public Products create(String protoName){
        Products p = showCase.get(protoName);
        return p.createClone();
    }
}

class ManagerBox implements Products{

    private char decochar;

    public ManagerBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length; i++) {
            System.out.print(decochar);
        }

        System.out.println();

        System.out.println(decochar + " " + s + " " + decochar);
        for (int i = 0; i < length + 4; i++) {

            System.out.print(decochar);
        }
        System.out.println();

    }

    @Override
    public Products createClone() {
        Products p = null;
        try {
            p = (Products) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();

        }
        return p;
    }
}

class UnderlinePen implements Products{
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(ulchar);
        }
        System.out.println();
    }

    @Override
    public Products createClone() {
        Products p = null;
        try {
            p = (Products) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return p;
    }
}
