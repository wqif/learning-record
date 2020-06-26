package pers.wqf.designpattern.principle.singleresponsibility;

/**
 * @author Qifeng Wen
 * @date 2020-06-24 下午9:05
 */

/**
 * 单一职责
 * 方案二
 * 遵守单一职责原则但是改动大，即按类分解同时修改客户端
 * 改进方案：直接修改Vehicle类改动代码少
 */
public class SingleResponsibility2 {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");
        roadVehicle.run("小轿车");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("大飞机");
    }
}


class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上飞驰。。。");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在天空中飞行。。。");
    }
}