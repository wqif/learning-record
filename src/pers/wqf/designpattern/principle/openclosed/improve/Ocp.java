package pers.wqf.designpattern.principle.openclosed.improve;


/**
 * @author Qifeng Wen
 * @date 2020-06-26 下午8:08
 */
public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
    }
}

// 这是一个用于绘图的类 (使用方)
class GraphicEditor {
    // 接收Shape对象，然后根据type来绘制不同图形
    public void drawShape(Shape shape) {
        shape.draw();
    }

}

abstract class Shape {
    abstract void draw();
}

class Rectangle extends Shape {

    @Override
    void draw() {
        System.out.println("矩形");
    }
}

class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("圆形");
    }
}

class Triangle extends Shape {

    @Override
    void draw() {
        System.out.println("三角形");
    }
}