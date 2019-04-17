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

#### 访问者模式(Visitor)

* **Visitor（抽象访问者）**

  抽象访问者为对象结构中每一个具体元素类ConcreteElement声明一个访问操作，从这个操作的名称或参数类型可以清楚知道需要访问的具体元素的类型，具体访问者则需要实现这些操作方法，定义对这些元素的访问操作。

* **ConcreteVisitor（具体访问者）**

  具体访问者实现了抽象访问者声明的方法，每一个操作作用于访问对象结构中一种类型的元素。

* **Element（抽象元素）**

  一般是一个抽象类或接口，定义一个Accept方法，该方法通常以一个抽象访问者作为参数。

* **ConcreteElement（具体元素）**

  具体元素实现了Accept方法，在Accept方法中调用访问者的访问方法以便完成一个元素的操作。

* **ObjectStructure（对象结构）**

  对象结构是一个元素的集合，用于存放元素对象，且提供便利其内部元素的方法。

#### 责任链模式(Chan of Responsibility)

将多个对象组成一条责任链，然后按照他们在责任链上的顺序一个一个的找出到底该谁来负责处理

* **Handler(处理者)**

  Handler角色定义了处理请求的接口，Handler角色知道下一个处理者是谁，如果自己无法处理请求，它会将请求转给下一个处理者。

* **ConcreteHandler(具体的处理者)**

  ConcreteHandler角色是处理请求的具体角色

* **Client(请求者)**
  Client角色是想第一个ConcreteHandler角色返送请求的角色。

#### 外观模式(Facade)

使用Facade模式可以为互相关联在一起的错综复杂的类整理出高层接口，其中Facade角色可以让系统对外只有一个简单的接口。而且，Facade角色还会考虑到系统内部各个类之间的责任关系和依赖关系，按照正确的顺序调用各个类。

* **Facade(窗口)**

  Facade角色是代表构成系统的许多其他角色的简单窗口，Facade角色想系统外部提供高层接口，由PageMaker类扮演此角色

* **Client(请求者)**

  Client角色负责调用Facade角色(该角色不包含在Facade模式中)，有Main类扮演此角色

* 构成系统的许多其他角色

  这些角色各自完成自己的工作，他们并不知道Facade角色，Facade角色调用其他角色进行工作，但是其他角色不会调用Facade角色。

#### 仲裁者模式(Mediator)

当我们需要调整多个对象之间的关系时，就需要用到Mediator模式了。即不让各个对线之间互相通信，而是增加一个仲裁者的角色，让他们各自与仲裁者通信，然后将控制显示的逻辑处理交给仲裁者负责。

* **Mediator(仲裁者)**

  Mediator角色负责定义与Colleague角色进行通信和做出决定的接口。由Mediator接口扮演此角色

* **ConcreteMediator(具体的仲裁者)**

  ConcreteMediator角色负责实现Mediator角色的接口，负责实际做出决定。由LoginFragme类扮演此角色。

* **Colleague(同事)**

  Colleague角色负责定义与Mediator角色进行通信的接口。由Colleague接口扮演此角色。

* **ConcreteColleague(具体的同事)**

  ConcreteColleague角色负责实现Colleague角色的忌口，由ColleagueButton、ColleagueTextField、ColleagueCheckBox扮演此角色

示例中ConcreteColleague角色可以复用，但ConcreteMediator角色很难复用。

#### 观察者模式(Observer)

发送状态变化通知

* **Subject(观察对象)**

  Subject角色表示观察对象。Subject角色定义了注册观察者和删除观察者的方法，此外，它还声明了获取现在状态的方法。由NumberGenerator扮演此角色

* **ConcreteSubject(具体的观察对象)**

  ConcreteSubject角色表示具体被观察的对象，当自身状态发生变化后，它会通知所有已经注册的Observer角色。由RandomNumberGenerator扮演此角色

* **Observer(观察者)**

  Observer角色负责接收来自Subject角色的状态变化 的通知。为此它声明了update方法。有Observer接口扮演此角色。

* **ConcreteObserver(具体的观察者)**

  ConcreteObserver角色表示具体的Observer。当它的update方法被调用后，会去获取要观察的对象的最新状态。由DigitObserver和GraphObserver扮演此角色

#### 备忘录模式(Memento)

* **Originator(生成者)**

  Originator角色会保存自己的最新状态时生成Memento角色。当把以前保存的Memento角色传递给Originator角色时，它会将自己恢复成该Memento角色时的状态。由Gamer类扮演此角色。

* Memento(备忘录)

  Memento角色会将Originator角色的内部信息整合在一起。在Memento角色中虽然保存了Originator角色的信息，但它不会向外部公开这些信息。

* Caretaker(负责人)

  当Caretaker角色想要保存当前的Originator角色的状态时，会通知Originator角色。Originator角色在接收到通知后会生成Memento角色的实例并将其返回给Caretaker角色。由于以后可能会用Memento实例来将Originator恢复至原来的状态。因此Caretaker角色会一直保存Memento实例。由Main扮演此角色

#### 状态模式(State)

用类来表示状态，通过切换类来方便的改变对象的状态。当需要增加新的状态时，如何修改代码这个问题也会很明确。

* **State(状态)**

  State角色表示状态，定义了根据不同状态进行不同处理的接口，该接口是那些处理内容依赖于状态的方法的集合。由State接口扮演此角色。

* ConcreteState(具体状态)

  ConcreteState角色表示各个具体的状态，它实现了State接口，由DayState和NightState扮演此角色。

* Context(状况、前后关系、上下文)

  Context角色持有表示当前状态的ConcreteState角色，此外它还定义了供外部调用者使用State模式的接口，由Context和SafeFrame类扮演此角色

#### 享元模式(Flyweight)

**通过尽量共享实例来避免new出实例**，但是如果要改变被共享的对象，就会对多个地方产生影响。

* **Flyweight(轻量级)**

  按照通常方式编写程序会导致程序变重，所以如果能共享实例会比较好。而Flyweight角色表示的就是那些实例会被共享的类。由ConcreteFlyweight扮演此角色

* **FlyweightFactoty(轻量级工厂)**

  FlyweightFactory角色是生成Flyweight角色的工厂。在工厂中生成Flyweight角色可以实现共享实例。由FlyweightFactory扮演此角色

* **Client(请求者)**

  Client角色使用FlyweightFactory角色来生成Flyweight角色。由Main类扮演此角色。

#### 代理模式(Proxy)

**只在必要时生成实例**

* **Subject(主体)**

  Subject角色定义了使用Proxy角色和RealSubject角色之间具有一致性的接口。由于存在Subject角色，所以Client角色不必在意它所使用的究竟是Proxy角色还是RealSubject角色。由Printable接口扮演此角色。

* **Proxy(代理人)**

  Proxy角色会尽量处理来自Client角色的请求。只有当自己不能处理时，它才会将工作交给RealSubject角色。Proxy角色只有在必要时才会生成RealSubject角色。Proxy角色实现了在Subject角色中定义的接口。由PrinterProxy类扮演此角色。

* **RealSubject(实际的主体)**

  "本人"RealSubject角色会在"代理人"Proxy角色无法胜任工作时出场。它与Proxy角色一样。也实现了Subject角色中定义的接口。由Printer类扮演此角色。

* **Client(请求者)**

  使用Proxy模式的角色。由Main类扮演

#### 命令模式(Command)

* **Command(命令)**

  Command 角色负责定义命令的接口，由Command接口扮演此角色

* ConcreteCommand(具体命令)

  ConcreteCommand角色负责实现在Command角色中定义的接口，由LightOnCommand和LightOffCommand扮演此角色

* Receiver(接收者)

  Receiver角色是Command角色执行命令时的对象，由Receiver扮演此角色

* Client(请求者)

  Client角色负责生成ConcreteCommand角色并分配Receiver角色。由Main类扮演此角色。

* Invoker(发动者)

  Invoker角色是开始执行命令的角色，他会调用在Command角色中定义的接口。由Invoker类扮演此角色

#### 解释器模式(Interperter)

给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。