package pers.wqf.designpattern.principle.singleresponsibility;

/**
 * @author Qifeng Wen
 * @date 2020-06-24 下午9:05
 */

/**
 * 单一职责
 * 方案一
 * 违反了单一职责原则
 * 解决方案：根据交通工具运行方法不同分解成不同类
 */
public class SingleResponsibility1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("小轿车");
        vehicle.run("大飞机");
    }
}


/**
 * 交通工具类
 */
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上飞驰。。。");
    }
}