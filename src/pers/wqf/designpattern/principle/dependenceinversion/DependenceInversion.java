package pers.wqf.designpattern.principle.dependenceinversion;

/**
 * @author Qifeng Wen
 * @date 2020-06-26 上午10:43
 */
public class DependenceInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email{
   public String getInfo(){
       return "Info： hello, world";
   }
}

// 完成person接受消息的功能
// 方式一
class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}


