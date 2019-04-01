/**
 * 适配器模式
 */
public class AdapterPatterns {
    public static void main(String... args) {
        Print p = new PrintBanner("hello");
        p.printStrong();
        p.printWeak();
    }
}


class Banner {
    private String name;

    public Banner(String name) {
        this.name = name;
    }

    public void showWithParen() {
        System.out.println("(" + name + ")");
    }

    public void showWithAster() {
        System.out.println("*" + name + "*");
    }
}

interface Print {
    void printWeak();

    void printStrong();
}

class PrintBanner extends Banner implements Print {

    public PrintBanner(String name) {
        super(name);
    }

    @Override
    public void printWeak() {
        showWithParen();

    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}