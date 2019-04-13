import java.util.ArrayList;
import java.util.Iterator;

/**
 * 组合模式
 * 容器和内容的一致性
 */
public class CompositePatterns {


    public static void main(String[] args) {
        System.out.println("Making root entries");
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");


        root.add(bin);
        root.add(tmp);
        root.add(usr);

        root.printList();


        System.out.println();

        System.out.println("Making user entries");
        Directory xuan = new Directory("xuan");
        Directory huang = new Directory("huang");
        Directory yuan = new Directory("yuan");
        usr.add(xuan);
        usr.add(huang);
        usr.add(yuan);


        xuan.add(new File("xuan.md",10));
        xuan.add(new File("xuan.html",20));
        root.printList();



    }


}

class FileTreatmentException extends RuntimeException{

    public FileTreatmentException(){}


    public FileTreatmentException(String msg){
        super(msg);
    }

}


abstract class Entry {
    abstract String getName();

    abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException{
        throw new FileTreatmentException();
    }


    public void printList(){
        printList("");
    }

    abstract void printList(String prefix);

    public String toString(){
        return getName() +"(" + getSize() +")";
    }

}

class File extends Entry{
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        return size;
    }

    @Override
    void printList(String prefix) {
        System.out.println(prefix +"/" + this);
    }
}



class Directory extends Entry{
    private String name;
    private ArrayList directory = new ArrayList();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getSize() {
        int size = 0;
        Iterator it = directory.iterator();
        while (it.hasNext()){
            Entry entry = (Entry) it.next();
            size+= entry.getSize();
        }
        return size;
    }

    public Entry add(Entry entry){
        directory.add(entry);
        return this;
    }


    @Override
    void printList(String prefix) {
        System.out.println(prefix +"/" + this);
        Iterator it = directory.iterator();
        while (it.hasNext()){
            Entry entry = (Entry) it.next();
            entry.printList(prefix +"/" + name);
        }


    }
}

