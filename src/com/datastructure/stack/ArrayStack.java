package com.datastructure.stack;

/**
 * @author Qifeng Wen
 * @date 2020-06-12 下午8:12
 */
public class ArrayStack {
    private int maxSize; // 栈的大小
    private Object[] stack; // 用来存放数据
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Object[maxSize];
    }


    // 判断栈满
    public boolean full() {
        return top == maxSize - 1;
    }

    // 判断栈空
    public boolean empty() {
        return top == -1;
    }

    // 返回栈顶元素
    public Object top() {
        if (empty()) {
            new RuntimeException("栈空");
        }

        return stack[top];
    }

    // 入栈
    public void push(Object val) {
        if (full()) {
            System.out.println("栈满, 无法添加数据");
            return;
        }

        stack[++top] = val;
    }

    // 出栈
    public Object pop() {
        if (empty()) {
            new RuntimeException("栈空");
        }

        return stack[top--];
    }

    // 栈的元素个数
    public int size() {
        return top + 1;
    }

    // 遍历栈
    public void list() {
        if (empty()) {
            System.out.println("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        System.out.println(stack.full());
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.size());
        System.out.println(stack.full());
        System.out.println(stack.empty());

        stack.list();
    }
}
