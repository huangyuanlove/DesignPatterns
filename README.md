#### 迭代器模式(Iterator)
 1. 实现自己的Iterator
 2. 在自己的集合类中定义返回该Iterator的方法
 3. 该Iterator持有集合类

 * main方法中的while循环不依赖BookShelf的实现*

##### 容易弄错"下一个"
next方法返回当前元素，并指向下一个元素
##### 容易弄错"最后一个"
 * hasNext可以理解为 确认接下来是否调用next方法

#### 适配器模式(Adapter)
* **Target(对象)**
该角色负责定义所需的方法，在示例中由Print接口(使用继承)和Print类(使用委托)扮演此角色

* **Client(请求者)**

  该角色负责使用Target角色所定义的方法进行具体处理。在示例中，由Main类扮演此角色

* **Adaptee(被适配)**

  注意不是Adapte-er(适配)角色，而是Adapt-ee(被适配)角色，Adaptee是一个持有既定方法的角色

* **Adapter(适配器)**

  Adapter模式的主人公，使用Adaptee角色的方法来满足Target角色的需求，这是Adapter模式的目的，也是Adapter角色的作用，在示例中由PrintBanner来扮演这个角色

在类适配器模式中，Adapter角色通过继承来使用Adaptee角色，而在对象适配器模式中，Adapter角色通过委托来使用Adaptee角色。

#### 模板模式(Template)

模板模式：在父类中定义处理流程的框架，在子类中实现具体处理的模式

组成模板的方法被定义在父类中，由于这些方法是抽象的，所以无法知道这些方法最终的实现方式，唯一知道的是父类如何调用这些方法的

* **AbstracClass（抽象类）**

  不仅负责实现模板方法，还负责声明在模板方法中所使用到的抽象方法。这些抽象方法由子类ConcreteClass角色负责实现

* **ConcreteClass（具体类）**

  该角色负责具体实现AbstractClass角色中定义的抽象方法。



#### 工厂模式(Factory)

父类决定实例生成的方式，但并不决定所要生成的具体的类。具体的处理全部交给子类负责。

* **Product(产品)**

  它定义了在Factory Method模式中生成的那些实例所持有的接口，但具体的处理则由子类ConcreteProduct角色决定。

* **Creator(创建者)**

  它是负责生成Product角色的抽象类，但具体的处理规则由子类ConcreteCreate角色决定。

  Create角色对于实际负责生成的实力ConcreteCreator一无所知，它唯一知道的就是只要调用Product角色的生成实例的方法，就可以得到Product的实例。

* **ConcreteProduct(具体的产品)**

  ConcreteProduct决定了具体的产品。

* **ConcreteCreator(具体的创建者)**

  它负责生成具体的产品

#### 单例模式(Singleton)

多种写法，这里推荐双重检查和静态内部类的方式

#### 原型模式(Prototype)

通过new产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。就是java中的克隆技术，以某个对象为原型，复制出新的对象。显然，新的对象具备原型对象的特点。

> clone方法定义在Object中，是一个native方法。
>
> Cloneable接口并没有声明任何方法，它只是被用来标记"可使用cline方法进行复制"的。
>
> clone方法是浅拷贝，只是将复制实例的字段值直接复制到新的实例当中。比如类字段是一个数组时，clone并不会复制另外一个数组出来，只是复制该字段的引用。

* **Prototype(原型)**

  Products角色负责定义用于复制现有实例来生成新实例的方法。

* **ConcretePrototype(具体的原型)**

  ConcreteProtype角色负责实现现有实例来横撑新实例的方法

* **Client(使用者)**

  Client角色负责使用复制实例的方法生成新的实力。

#### 构建者模式(Builder)

* **Builder(建造者)**

  Builder角色是负责定义用于生成实例的接口。

* **ConcreteBuilder(具体的建造者)**

  ConcreteBuilder角色是负责实现Builder角色接口的类。

* **Director(监工)**

  Director角色负责使用Builder角色的接口来生成实例。

* **Client(使用者)**

  


