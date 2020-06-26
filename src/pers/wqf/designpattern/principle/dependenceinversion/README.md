## 依赖倒转原则

+ 高层模块不应该依赖底层模块，二者都应该依赖其抽象
+ 抽象不应该依赖细节，细节应该依赖抽象
+ 依赖倒转的中心思想是面向接口编程
+ 依赖倒转原则是基于这样的设计理念：相对于细节的多变性，抽象的东西要稳定的多。以抽象为基础搭建的架构比以细节为基础搭建的架构要稳定的多。在java中抽象指的是接口或抽象类，细节就是具体的实现类
+ 使用接口或抽象类的目的是制定好规范，而不涉及任何具体的操作，把展现细节任务交给他们的实现类去完成

##### 应用实例
**模拟Person接收消息的功能**

方案一：

```java
class Email{
   public String getInfo(){
       return "Info： hello, world";
   }
}

// 完成person接受消息的功能
class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}
```
上述方案比较容易想到，但如果我们获取的对象是短信、WeChat、QQ等等呢，即新增类同时也想增加相应的接收方法，这种代码看起来不太优雅。

此时我们想为何不引进一个接口IReceiver表示接收者，这样Person类与接口发生依赖，这时Email、Wechat、QQ实现IReceiver接口，这样我们就符合了依赖倒转原则。

方案二：
```java
public class DependenceInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeChat());
    }
}

interface IReceiver {
    String getInfo();
}

class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "Email Info： hello, world";
    }
}

class WeChat implements IReceiver {
    @Override
    public String getInfo() {
        return "WeChat Info： hello, world";
    }
}

// 完成person接受消息的功能
// 方式二
class Person {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
```
可以看到不管到时有多少类，只需实现IReceiver接口就完成依赖的传递了