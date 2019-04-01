import java.util.Iterator;




/**迭代器模式
 * 实现自己的Iterator
 * 在自己的集合类中定义返回该Iterator的方法
 * 该Iterator持有集合类
 *
 *
 * main方法中的while循环不依赖BookShelf的实现
 *
 * 容易弄错"下一个"
 * next方法返回当前元素，并指向下一个元素
 *
 * 容易弄错"最后一个"
 * hasNext可以理解为 确认接下来是否调用next方法
 */
public class IteratorPatterns {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        BookShelf bookShelf = new BookShelf(10);
        for(int i =0;i<10;i++){
            Book book = new Book("name"+i);
            bookShelf.appendBook(book);
        }

        Iterator<Book> iterator = bookShelf.iterator();

        while (iterator.hasNext()){

            System.out.println(iterator.next().getName());
        }


    }
}

class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class BookShelf  {

    private Book[] books;
    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public void appendBook(Book book) {
        books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    public Book getBookByIndex(int index) {
        return books[index];
    }


    public Iterator<Book> iterator() {


        return new BookShelfIterator(this);
    }
}

class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Book next() {
        Book book = bookShelf.getBookByIndex(index);
        index++;
        return book;
    }
}