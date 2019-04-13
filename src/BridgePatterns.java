public class BridgePatterns {
}

abstract class DisplayImpl {
    abstract void rawOpen();

    abstract void rawPrint();

    abstract void rawClose();
}

class StringDisplayImpl extends DisplayImpl {
    private String rawString;
    private int width;

    public StringDisplayImpl(String rawString, int width) {
        this.rawString = rawString;
        this.width = width;
    }

    @Override
    void rawOpen() {
        printLine();
    }

    @Override
    void rawPrint() {
        System.out.println("|" + rawString + "|");

    }

    @Override
    void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

}

class Display{
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }
    void open(){
        impl.rawOpen();
    }
    void print(){
        impl.rawPrint();
    }
    void close(){
        impl.rawClose();
    }

    public final void display(){
        open();
        print();
        close();
    }


}

class CountDisplay extends Display{

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    void multiDisplay(int time){
        open();
        for (int i = 0; i < time; i++) {
            print();
        }
        close();
    }

}
