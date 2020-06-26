package pers.wqf.designpattern.principle.openclosed;


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

// 这是一个用于绘图的类
class GraphicEditor {
    // 接收Shape对象，然后根据type来绘制不同图形
    public void drawShape(Shape shape) {
        if (shape.m_type == 1) {
            drawRectangle(shape);
        } else if (shape.m_type == 2) {
            drawCircle(shape);
        }else if (shape.m_type == 3) {
            drawTriangle(shape);
        }
    }

    private void drawRectangle(Shape shape) {
        System.out.println("矩形");
    }

    private void drawCircle(Shape shape) {
        System.out.println("圆形");
    }

    private void drawTriangle(Shape shape) {
        System.out.println("三角形");
    }
}

class Shape {
    int m_type;
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }
}