package com.datastructure.linkedlist;

/**
 * @author Qifeng Wen
 * @date 2020-06-06 下午3:36
 */
public class Node {
    public Integer data;
    public Node next;
    public Node pre;

    public Node(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
