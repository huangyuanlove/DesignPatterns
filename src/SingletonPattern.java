import com.sun.org.apache.bcel.internal.generic.SIPUSH;

/**
 * 单例模式
 */


public class SingletonPattern {

}

/**
 * 饿汉式(静态常量)可用
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */

class SingletonA{
    private final static SingletonA INSTANCE = new SingletonA();
    private SingletonA(){}

    public static SingletonA getInstance(){
        return INSTANCE;
    }
}

/**
 * 双重检查
 * 优点：线程安全；延迟加载；效率较高。
 */
class SingletonB{
    private static volatile SingletonB singletonB;
    private SingletonB(){}
    public static SingletonB getInstance(){
        if(singletonB ==null){
            synchronized (SingletonB.class){
                if(singletonB == null){
                    singletonB = new SingletonB();
                }
            }
        }
        return singletonB;
    }
}

/**静态内部类
 * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性
 * 优点：避免了线程不安全，延迟加载，效率高。
 */

class SingletonC{
    private SingletonC(){}

    private static class SingletonInstance{
        private static final  SingletonC INSTANCE = new SingletonC();
    }

    public static SingletonC getInstance(){
        return SingletonInstance.INSTANCE;
    }

}

/**
 * 枚举[推荐用]
 * 借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 */
 enum SingletonD{
    INSTANCE;
    public void otherMethod(){}
}