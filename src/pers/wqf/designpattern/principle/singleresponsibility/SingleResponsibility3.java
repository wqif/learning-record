package pers.wqf.designpattern.principle.singleresponsibility;

/**
 * @author Qifeng Wen
 * @date 2020-06-24 下午9:18
 */

/**
 * 方案三 通常在类比较简单时可以使用方案三
 * 该方案没有对原来的类做大的修改，只是增加方法
 * 这里虽然没有在类上遵守单一职责原则，但是在方法级别上扔遵守单一职责原则
 */
public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.runWater("轮船");
        vehicle.runRoad("小轿车");
        vehicle.runAir("大飞机");
    }
}

class Vehicle2 {
    public void runRoad(String vehicle) {
        System.out.println(vehicle + "在公路上飞驰。。。");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + "在天空中上飞行。。。");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "在水面上航行。。。");
    }
}
