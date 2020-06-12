package com.datastructure.stack;


import com.datastructure.linkedlist.SingleLikedList;

/**
 * @author Qifeng Wen
 * @date 2020-06-12 下午9:01
 */
public class SingleLikedListStack<T> {
    private Node<T> top; // 指向栈顶元素
    private int size = 0; // 记录栈的元素个数

    public SingleLikedListStack() {
        top = null;
    }

    public boolean empty() {
        return top == null;
    }

    public T top() {
        if (empty()) {
            new RuntimeException("栈空");
        }
        return this.top.getData();
    }

    public void push(T data) {
        if (top == null) {
            top = new Node<>(data);
        } else {
            Node<T> tNode = new Node<>(data);
            tNode.setNext(top);
            top = tNode;
        }
        size++;
    }

    public T pop() {
        if (empty()) {
            new RuntimeException("栈空");
        }
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public int size() {
        return size;
    }


    public void list() {
        Node<T> curNode = top;
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
        SingleLikedListStack<Integer> stack = new SingleLikedListStack();
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.top());
        System.out.println(stack.size());
        System.out.println(stack.empty());

        stack.list();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
