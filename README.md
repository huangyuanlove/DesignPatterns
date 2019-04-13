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

  ConcretePrototype角色负责实现现有实例来横撑新实例的方法

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
#### 桥接模式(Bridge)

将类的功能层次结构与实现层次结构分离

> 希望新加功能时，我们会继承某个父类，在子类中增加某些方法，这就是为了增加新功能而产生的层次结构。
>
> 父类具有基本功能，子类中增加新的功能。
>
> 以上这种层次结构称为"类的功能层次结构"

> 希望新增实现时，父类的人物是通过声明抽象方法的方式定义接口，而子类的任务是实现抽象方法。这种类的层次结构并非用于方便我们增加新的方法。它的真正作用是实现任务分担：父类通过声明抽象方法来定义接口，子类通过实现具体方法来实现接口。正式由于父类和子类的任务分组，我们才可以编写出具有高科替换性的类。这种层次结构被称为"类的实现层次结构"

* **Abstraction(抽象化)  Display**

  该角色位于"类的功能层次结构"的最上层，它使用Implementor角色的方法定义了基本的功能，该角色中保存了Implementor角色的实例。

* **RefinedAbstraction(改善后的抽象化)  CountDisplay**

  在Abstraction角色的基础上增加了新功能的角色

* **Implementor(实现者) DisplayImpl**

  该角色位于"类的实现层次结构"的最上层。

* **ConcreteImplementor(具体实现者) StringDisplayImpl**

  该角色负责实现在Implementor角色中定义的接口

#### 策略模式(Strategy)

其思想是针对一组算法，将每一种算法都封装到具有共同接口的独立的类中，从而是它们可以相互替换。策略模式的最大特点是使得算法可以在不影响客户端的情况下发生变化，从而改变不同的功能。

* **Strategy(策略)**

  Strategy角色负责决定实现策略所必须的接口

* **ConcreteStrategy(具体的策略)**

  ConcreteStrategy角色负责Strategy角色的接口，也就是负责实现具体的策略。

* **Context(上下文)**

  负责使用Strategy角色，Context角色保存了ConcreteStrategy角色的实力，并使用ConcreteStrategy角色去实现需求。

####  组合模式(Composite)

内容与容器的一致性(以计算机文件夹为例)

* **Leaf(树叶)**

  表示内容的角色，该角色中不能放入其他对象。由File类扮演此角色

* **Composite(复合物)**

  表示容器的角色，可以在其中放入Leaf角色和Composite角色，由Directory类扮演此角色

* **Component**

  使Leaf角色和Composite角色具有一致性的角色。Component角色是Leaf角色和Composite角色的父类。由Entry类扮演此角色

* Client

  使用Composite模式的角色。由Main类扮演此角色

使用Composite模式可以使容易与内容具有一致性，也可以称其为**多个和单个的一致性**，即将多个对象结合在一起，当做一个对象进行处理。

#### 装饰模式(Decorator)

* **Componet**

  增加功能时的核心角色。由DecoratorDisplay类扮演此角色

* **ConcreteComponent**

  该角色是实现了Component角色所定义的接口。由StringDisplay扮演此角色

* **Decorator(装饰物)**

  该角色具有与Component角色相同的接口。在它内部保存了被装饰对象--Component角色。Decorator角色知道自己要装饰的对象。由Border类扮演此角色

* **ConcreteDecorator(具体装饰物)**

  该角色是具体的Decorator角色。由SideBorder类和FullBorder类扮演。





