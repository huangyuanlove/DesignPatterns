import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 备忘录模式
 */
public class MementoPatterns {

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 20; i++) {
            System.out.println("=========");
            System.out.println("当前状态：" + gamer);
            gamer.bet();
            System.out.println("所持金钱为" + gamer.getMoney() + "元");
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("（所持金钱增加了，保存当前状态）");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("（所持金钱减少了许多，恢复至上一次状态）");
                gamer.restoreMemento(memento);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }

}


class Memento {
    int money;
    ArrayList<String> fruits;

    public int getMoney() {
        return money;
    }

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    public ArrayList<String> getFruits() {
        return (ArrayList<String>) fruits.clone();
    }
}

class Gamer {
    private int money;
    private List fruits = new ArrayList<>();
    private Random random = new Random();
    private static String[] fruitsName = {"苹果", "葡萄", "香蕉", "橘子"};


    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        switch (dice) {
            case 1:
                money += 100;
                System.out.println("所持金钱增加了");
                break;
            case 2:
                money /= 2;
                System.out.println("所持金钱减半");
                break;
            case 6:
                String f = getFruit();
                System.out.println("获得了水果：" + f);
                fruits.add(f);
                break;
            default:
                System.out.println("什么都没有发生");
                break;
        }


    }


    public Memento createMemento() {
        Memento m = new Memento(money);
        Iterator it = fruits.iterator();
        while (it.hasNext()) {
            String f = (String) it.next();
            if (f.startsWith("好吃的")) {
                m.addFruit(f);
            }

        }

        System.out.println("Memento:"+ m.getFruits().toString());
        return m;
    }


    public void restoreMemento(Memento memento) {
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                '}';
    }

    private String getFruit() {

        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "好吃的";
        }

        return prefix + fruitsName[random.nextInt(fruitsName.length)];

    }

}

