/**
 * 模板模式：在父类中定义处理流程的框架，在子类中实现具体处理的模式
 * 组成模板的方法被定义在父类中，由于这些方法是抽象的，所以无法知道这些方法最终的实现方式，唯一知道的是父类如何调用这些方法的
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        AbstractDisplay abstractDisplay = new CharDisplay('H');
        AbstractDisplay abstractDisplay1 = new StringDisplay("Hello world");
        AbstractDisplay abstractDisplay2 = new StringDisplay("你好 世界");


        abstractDisplay.display();
        abstractDisplay1.display();
        abstractDisplay2.display();

    }

}

abstract class AbstractDisplay{
   abstract void open();
    abstract void print();
    abstract void close();
    public final  void display(){
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}

class CharDisplay extends AbstractDisplay{
private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    void open() {
        System.out.print("<<");
    }

    @Override
    void print() {
        System.out.println(ch);
    }

    @Override
    void close() {
        System.out.println(">>");
    }
}


class StringDisplay extends AbstractDisplay{
    private String string;
    private int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.getBytes().length;
    }

    public void printLine(){
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.print("+");
    }


    @Override
    void open() {
        printLine();
    }

    @Override
    void print() {
        System.out.println("!"+ string +"!");
    }

    @Override
    void close() {
        printLine();

    }
}
