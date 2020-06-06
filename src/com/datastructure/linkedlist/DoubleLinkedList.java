package com.datastructure.linkedlist;

/**
 * @author Qifeng Wen
 * @date 2020-06-06 下午3:46
 */
public class DoubleLinkedList {
    private Node head = null;

    public Node getHead() {
        return head;
    }

    /**
     * 尾部添加Node
     *
     * @param node
     */
    public void add(Node node) {
        if (head == null) {
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            // 当找到链表最后一个节点时，退出循环
            temp = temp.next;
        }
        // 形成一个双向链表
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 按顺序添加Node
     *
     * @param node
     */
    public void addByOrder(Node node) {
        if (head == null) {
            head = node;
            return;
        }

        if (head.data > node.data) {
            node.next = head;
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data <= node.data) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public Node query(int data) {

        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    public void update(Node newNode, int data) {
        if (head == null) {
            System.out.println("当前列表为空");
            return;
        }
        Node temp = head;
        boolean flag = false;
        while (temp != null) {
            if (temp.data == data) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.data = newNode.data;
        } else {
            System.out.println("没有找打data值为" + data + "的Node");
        }
    }

    /**
     * 删除Node
     *
     * @param data
     */
    public void delete(int data) {
        if (head == null) {
            System.out.println("当前链表为空");
        }
        Node temp = head;
        if (temp.data == data) { // 如果要删除的节点是头结点
            temp.next.pre = null; // 将第二个节点的上一个节点等于null
            head = temp.next; // 让head等于第二个节点
            return;
        }


        boolean flag = false;
        while (temp != null) {
            if (temp.data == data) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) // 如过temp是最后一个节点则不处理
                temp.next.pre = temp.pre;
        } else {
            System.out.println("找不到data值为" + data + "的Node");
        }
    }

    public void printList() {

        Node temp = head;
        while (true) {
            if (temp == null)
                break;

            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void clear() {
        head = null;
    }


    public Node reverse(Node head) {
        if (head.next == null) {
            this.head = head;
            return head;
        }
        Node node = reverse(head.next);
        node.next = head;
        head.next = null;
        return head;

    }

}
