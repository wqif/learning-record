package pers.wqf.designpattern.principle.dependenceinversion.improve;

/**
 * @author Qifeng Wen
 * @date 2020-06-26 上午10:43
 */
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


