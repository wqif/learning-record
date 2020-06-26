package pers.wqf.datastructure.queue;


/**
 * @author Qifeng Wen
 * @date 2020-06-12 下午9:32
 */
public class SingleLikedListQueue<T> {
    private Node<T> head; // 指向队首元素
    private Node<T> tail; // 指向队首元素
    private int size = 0; // 记录队列的元素个数

    public SingleLikedListQueue() {
        head = null;
        tail = null;
    }

    public boolean empty() {
        return size == 0;
    }

    public T peek() {
        if (empty()) {
            throw new RuntimeException("队列空");
        }
        return this.head.getData();
    }

    public void enqueue(T data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
        } else {
            Node<T> tNode = new Node<>(data);
            tail.setNext(tNode);
            tail = tNode;
        }
        size++;
    }

    public T dequeue() {
        if (empty()) {
            throw new RuntimeException("队列空");
        }
        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    public int size() {
        return size;
    }


    public void list() {
        Node<T> curNode = head;
        while (curNode != null) {
            System.out.println(curNode.getData());
            curNode = curNode.getNext();
        }
    }

    private class Node<T> {


        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SingleLikedListQueue<Integer> stack = new SingleLikedListQueue();
        System.out.println(stack.empty());
        stack.enqueue(1);
        stack.enqueue(2);
        stack.enqueue(3);
        stack.enqueue(4);

        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.empty());

        stack.list();
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.size());
    }
}
