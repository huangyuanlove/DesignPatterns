
/**
 * 代理模式
 */
public class ProxyPatterns {

    public static void main(String[] args) {
        Printable p = new PrinterProxy("xuan");
        System.out.println("现在的名字是" + p.getPrintName() );
        p.setPrintName("yuan");
        System.out.println("现在的名字是" + p.getPrintName());

        p.print("Hello world");
    }

}

interface Printable{
    void setPrintName(String name);
    String getPrintName();
    void print(String string);
}


class Printer implements Printable{

    private String name;

    public Printer() {
        heavyJob("正在生成Printer实例");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("正在生成Printer实例（" + name +"）");
    }

    private void heavyJob(String msg){
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(".");
        }
        System.out.println("结束");


    }

    @Override
    public void setPrintName(String name) {
        this.name = name;
    }

    @Override
    public String getPrintName() {
        return name;
    }

    @Override
    public void print(String string) {
        System.out.println("=====" + name +"=====");
        System.out.println(string);
    }
}

class PrinterProxy implements Printable{
    private String name;
    private Printer real;

    public PrinterProxy() {
    }

    public PrinterProxy(String name) {
        this.name = name;
    }


    @Override
    public synchronized void setPrintName(String name) {
        if(real!=null){
            real.setPrintName(name);
        }
        this.name = name;

    }

    @Override
    public String getPrintName() {
        return name;
    }

    @Override
    public void print(String string) {
            realize();
            real.print(string);

    }

    private synchronized void realize(){
        if(real == null){
            real = new Printer(name);
        }
    }

}