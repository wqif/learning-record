package pers.wqf.datastructure.queue;


/**
 * @author Qifeng Wen
 * @date 2020-06-02 下午7:47
 */

/**
 * 数组实现固定容量队列
 */
public class ArrayCircleQueue {
    private Object[] objects;
    private int head = 0; //第一个元素的索引
    private int tail = 0; //最后一个元素下一个索引
    private int maxSize; //数组总大小， 需预留一个位置 有效数据为maxSize-1，如果不预留一个位置无法确定队列当前是满还是空

    public static void main(String[] args) {
        ArrayCircleQueue integerArrayCircleQueue = new ArrayCircleQueue(5);
        integerArrayCircleQueue.enqueue(1);
        integerArrayCircleQueue.enqueue(2);
        integerArrayCircleQueue.enqueue(3);
        integerArrayCircleQueue.enqueue(4);
        integerArrayCircleQueue.show();
        integerArrayCircleQueue.dequeue();
        integerArrayCircleQueue.dequeue();
        integerArrayCircleQueue.show();
        integerArrayCircleQueue.enqueue(5);
        integerArrayCircleQueue.show();
        System.out.println(integerArrayCircleQueue.peek());

    }

    public ArrayCircleQueue(int size) {
        maxSize = size;
        objects = new Object[size];
    }

    public boolean empty() {
        return tail == head;
    }

    public boolean full() {
        return (tail + 1) % maxSize == head;
    }

    public boolean enqueue(Object o) {
        if (full()) {
            System.out.println("队列满，无法添加");
            return false;
        }

        objects[tail] = o;
        tail = (tail + 1) % maxSize;
        return true;
    }

    public Object dequeue() {
        if (empty()) {
            System.out.println("队列空，无法获取");
            return null;

        }
        Object object = objects[head];
        head = (head + 1) % maxSize;
        return object;
    }


    public Object peek() {
        if (!empty())
            return objects[head];
        return null;
    }

    public int size() {
        return (tail + maxSize - head) % maxSize;
    }

    public void show() {
        for (int i = head; i < head + size(); i++) {
            System.out.println(objects[i % maxSize]);
        }
    }

}
