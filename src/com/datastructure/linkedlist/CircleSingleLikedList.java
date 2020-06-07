package com.datastructure.linkedlist;

/**
 * @author Qifeng Wen
 * @date 2020-06-07 上午9:45
 */
public class CircleSingleLikedList {
    private Node first;

    public Node getFirst() {
        return first;
    }

    /**
     * 添加节点，构成环形链表
     *
     * @param num
     */
    public void add(int num) {
        if (num < 1) {
            System.out.println("num的值必须大于0");
            return;
        }

        first = new Node(1);
        first.next = first;
        Node curNode = first; //辅助指针，帮助构建环形链表
        for (int i = 2; i <= num; i++) {
            // 根据编号创建节点
            Node node = new Node(i);
            curNode.next = node;
            node.next = first;
            curNode = node;
        }
    }

    public void printList() {
        if (first == null) {
            return;
        }
        Node curNode = first;
        while (curNode != null) {
            System.out.println(curNode);
            curNode = curNode.next;
            if (curNode == first)
                break;
        }

    }

    public static void main(String[] args) {
        CircleSingleLikedList circleSingleLikedList = new CircleSingleLikedList();
        circleSingleLikedList.add(5);
        circleSingleLikedList.printList();
    }
}
